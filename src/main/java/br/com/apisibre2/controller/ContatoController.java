package br.com.apisibre2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apisibre2.model.ContatoModel;
import br.com.apisibre2.serviceImpl.ContatoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



//@RequestMapping(value="/api")
//@Api(value="API REST contato")
@RestController
@CrossOrigin(origins="*")
public class ContatoController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ContatoServiceImpl cads;

	@GetMapping("/contato")
	@ApiOperation(value="Retorna uma lista de Contatos")
	public List<ContatoModel> findAll() {
		return cads.listAll();
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value="Encontra os contatos pelo id")
	public ResponseEntity<ContatoModel> listaPorId(@PathVariable(name = "id") Long id) {
		ContatoModel cad = cads.getId(id);
		return ResponseEntity.ok(cad);
	}

	@PostMapping("/contato")
	@ApiOperation(value="Adiciona contatos a lista")
	public ResponseEntity savaCotato(@RequestBody ContatoModel cad) {
		this.cads.saveOrUpdate(cad);
		sendMail();
		return ResponseEntity.ok("Ok");
	}

	@PutMapping(path = "/{id}")
	@ApiOperation(value="Faz o update dos contatos")
	public ResponseEntity<Boolean> cadastra(@PathVariable(name = "id") Long id, @RequestBody ContatoModel cm,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return null;
		}
		cm.setId_c(id);
		boolean cad = cads.alterar(cm);
		return ResponseEntity.ok(cad);
	}

	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
	@ApiOperation(value="Envia emails aos contatos")
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Alguem entrou em contato no site! Gl??ria a Deus sempre!");
		message.setTo("eb656c3f0f-5d2a1a@inbox.mailtrap.io");
		message.setFrom("eb656c3f0f-5d2a1a@inbox.mailtrap.io");
		try {
			mailSender.send(message);
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar email.";
		}
	}
}
