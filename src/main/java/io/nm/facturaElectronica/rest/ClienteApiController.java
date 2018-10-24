package io.nm.facturaElectronica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.nm.facturaElectronica.model.Cliente;
import io.nm.facturaElectronica.model.JsonResult;
import io.nm.facturaElectronica.services.IClienteService;
import io.nm.facturaElectronica.util.TextValue;

@Controller
@RequestMapping("cliente")
public class ClienteApiController {
	@Autowired
	private IClienteService clienteService;
	
	@CrossOrigin
	@PostMapping("add")
	public ResponseEntity<JsonResult> add(@RequestBody Cliente req) {
		JsonResult result = null;
		ResponseEntity<JsonResult> toReturn = null;
		try {
			if (req != null && req.getoDomicilio() != null) {
				int idGenerado = clienteService.addCliente(req);
				if (idGenerado >= 0) {
					result = new JsonResult(true, "El cliente fue agregado con exito.", idGenerado);
					toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.OK);
				} else {
					result = new JsonResult(false, "Error al agregar nuevo cliente");
					toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				result = new JsonResult(false, "Error en los parametros");
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(false, e.getMessage(), e);
			toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return toReturn;
	}
	
	@CrossOrigin
	@PutMapping("edit")
	public ResponseEntity<JsonResult> edit(@RequestBody Cliente req) {
		JsonResult result = null;
		ResponseEntity<JsonResult> toReturn = null;
		try {
			if (req != null && req.getoDomicilio() != null) {
				boolean editado = clienteService.editCliente(req);
				if (editado) {
					result = new JsonResult(true, "El cliente fue actualizado con exito.");
					toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.OK);
				} else {
					result = new JsonResult(false, "Error al editar cliente");
					toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				result = new JsonResult(false, "Error en los parametros");
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(false, e.getMessage(), e);
			toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return toReturn;
	}
	
	@CrossOrigin
	@RequestMapping(path = { "/get/{idCliente}"}, method = { RequestMethod.GET })
	public ResponseEntity<JsonResult> get(@PathVariable("idCliente") int idCliente) {
		JsonResult result = null;
		ResponseEntity<JsonResult> toReturn = null;
		try {
			Cliente obtenido = clienteService.getClienteById(idCliente);
			if (obtenido != null) {
				result = new JsonResult(true, "Ok", obtenido);
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.OK);
			} else {
				result = new JsonResult(false, "Error al obtener cliente por id");
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(false, e.getMessage(), e);
			toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return toReturn;
	}
	
	@CrossOrigin
	@RequestMapping(path = { "/search/{busqueda}"}, method = { RequestMethod.GET })
	public ResponseEntity<JsonResult> get(@PathVariable("busqueda") String busqueda) {
		JsonResult result = null;
		ResponseEntity<JsonResult> toReturn = null;
		try {
			List<TextValue> obtenido = clienteService.searchCliente(busqueda);
			if (obtenido != null) {
				result = new JsonResult(true, "Ok", obtenido);
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.OK);
			} else {
				result = new JsonResult(false, "Error al obtener cliente por id");
				toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(false, e.getMessage(), e);
			toReturn = new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return toReturn;
	}
}
