package com.ruml.ecommerce.presentation.controller.settings;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @GetMapping("/store")
    public Object getSettings() { return null; }
    @PostMapping("/store")
    public Object updateSettings(@RequestBody Object request) { return null; }
}
