package com.marcoscouto.vault;

import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend.KV_2;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final VaultTemplate vaultTemplate;

    public StatusController(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    @GetMapping("/v1")
    public Map getResponseV1() {
        // write and read - just v1
        var featuresPath = "/features/first_feature";
        vaultTemplate.write(featuresPath, Map.of("enabled", true));
        return vaultTemplate.read(featuresPath).getData();
    }

    @GetMapping("/v2")
    public Map getResponseV2() {
        // opsForKeyValue - v1 and v2
        vaultTemplate.opsForKeyValue("features2", KV_2).put("first_feature", Map.of("enabled", true));
        return vaultTemplate.opsForKeyValue("features2", KV_2).get("first_feature").getData();
    }

}
