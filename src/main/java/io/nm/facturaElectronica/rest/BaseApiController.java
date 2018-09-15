package io.nm.facturaElectronica.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.nm.facturaElectronica.model.JsonResult;

@RestController
public class BaseApiController {
	@CrossOrigin
	@GetMapping("/isAlive")
	public JsonResult isAlive() {
		try {
			return new JsonResult(true, "is alive...", null);
		} catch (Exception ne) {
			ne.printStackTrace();
			return new JsonResult(false, "error", null);
		}
	}
}
