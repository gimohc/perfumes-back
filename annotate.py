import os
import glob
import re

controllers = [
    'ruml-backend-presentation/ruml-backend-presentation-controller-audit/src/main/java/com/ruml/ecommerce/presentation/controller/audit/AuditController.java',
    'ruml-backend-presentation/ruml-backend-presentation-controller-auth/src/main/java/com/ruml/ecommerce/presentation/controller/auth/AuthController.java',
    'ruml-backend-presentation/ruml-backend-presentation-controller-order/src/main/java/com/ruml/ecommerce/presentation/controller/order/OrderController.java',
    'ruml-backend-presentation/ruml-backend-presentation-controller-perfume/src/main/java/com/ruml/ecommerce/presentation/controller/perfume/PerfumeController.java',
    'ruml-backend-presentation/ruml-backend-presentation-controller-store/src/main/java/com/ruml/ecommerce/presentation/controller/store/StoreController.java',
    'ruml-backend-presentation/ruml-backend-presentation-controller-support/src/main/java/com/ruml/ecommerce/presentation/controller/support/SupportController.java'
]

for c in controllers:
    if not os.path.exists(c):
        print(f"Skipping {c}, not found.")
        continue
    with open(c, 'r') as f:
        content = f.read()

    if 'io.swagger.v3.oas.annotations.tags.Tag' not in content:
        content = content.replace('import org.springframework.web.bind.annotation.RestController;', 'import org.springframework.web.bind.annotation.RestController;\nimport io.swagger.v3.oas.annotations.tags.Tag;\nimport io.swagger.v3.oas.annotations.Operation;')
        
        match = re.search(r'public class (\w+)Controller', content)
        if match:
            name = match.group(1)
            content = content.replace('@RestController', f'@RestController\n@Tag(name = "{name}", description = "{name} management API")')
        
            # Add basic @Operation to all GetMapping/PostMapping
            content = re.sub(r'(@(Get|Post|Put|Delete)Mapping.*?)\n\s+public', r'\1\n    @Operation(summary = "\2 operation")\n    public', content)
        
            with open(c, 'w') as f:
                f.write(content)
            print(f'Annotated {c}')
