package br.ucb.minhafarmacia.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.ucb.minhafarmacia.entidades.Dose;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.MedicamentoDTO;

public class BuscaMedicamentoWS {
	public Medicacao buscaMedicamento(String codBarras){
		Client cliente = Client.create();
		WebResource webResource = cliente.resource("http://mobile-aceite.tcu.gov.br:80/mapa-da-saude/rest/remedios?codBarraEan="+codBarras+"&quantidade=1");
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
//		System.out.println("resposta da operacao get");
		String output = response.getEntity(String.class);
		System.out.println(output);
	
		
		Gson gson = new Gson();
		MedicamentoDTO mDto = gson.fromJson(trataString(output),MedicamentoDTO.class);
		System.out.println(mDto.getApresentacao()+" --> "+mDto.getPrincipioAtivo());
		return populaMedicacao(mDto);
	}
	
	private String trataString(String resposta){
		StringBuilder sb = new StringBuilder();
		sb.append(resposta);
		sb.delete(0, 1);
		sb.reverse().delete(0, 1);
		return sb.reverse().toString();
	}
	
	private Medicacao populaMedicacao(MedicamentoDTO mdto){
		Medicacao m = new Medicacao();
		m.setClasse_terapeutica(mdto.getClasseTerapeutica());
		m.setData_cadastro((GregorianCalendar) Calendar.getInstance());
		m.setNome(mdto.getProduto());
		m.setPrincipio_ativo(mdto.getPrincipioAtivo());
		m.setLaboratorio(mdto.getLaboratorio());
		m.setCod_barras(mdto.getCodBarraEan());
		try {
			m.setDose(populaDose());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	private Dose populaDose() throws ParseException{
		Dose d = new Dose();
		d.setIntervalo(0);
		d.setPeriodo_consumo(0);
		d.setTipo("");
		d.setQuantidade(0);
		d.setData_inicio((GregorianCalendar) Calendar.getInstance());
		d.setHora_inicio((GregorianCalendar) converteStringHora("00:00"));
		return d;
	}
	
	private static Calendar converteStringHora(String hora) throws ParseException {
		SimpleDateFormat formatoData = new SimpleDateFormat("HH:mm");

		Calendar c = Calendar.getInstance();
		c.setTime(formatoData.parse(hora));
		return c;
	}
}
