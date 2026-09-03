package com.ruml.ecommerce.presentation.controller.support;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class SupportController {
    @PostMapping("/contact")
    public Object contact(@RequestBody Object request) { return null; }
    @GetMapping("/admin/messages")
    public Object getMessages() { return null; }
    @PostMapping("/admin/messages")
    public Object processMessage(@RequestBody Object request) { return null; }
}
