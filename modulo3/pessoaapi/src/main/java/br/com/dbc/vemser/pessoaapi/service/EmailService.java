package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("mateus.castro@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Ola !\n" +
                "Estamos felizes em ter você em nosso sistema :)\n" +
                "Seu cadastro foi realizado com sucesso, seu indentificador é \n\n" +
                "Qualquer dúvida é entrar em contato com o suporte pelo e-mail " + from + ".\n\n" +
                "Att,\n" +
                "Sistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(from);
        helper.setSubject("Assunto 1");
        helper.setText("Ola !\n" +
                "Estamos felizes em ter você em nosso sistema :)\n" +
                "Seu cadastro foi realizado com sucesso, seu indentificador é \n\n" +
                "Qualquer dúvida é entrar em contato com o suporte pelo e-mail " + from + ".\n\n" +
                "Att,\n" +
                "Sistema.");

        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(PessoaCreateDTO pessoaQueVaiReceberEmail, String tipo) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto 3");
            mimeMessageHelper.setText(geContentFromTemplate(pessoaQueVaiReceberEmail, tipo), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplate(PessoaCreateDTO pessoa, String tipo) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", from);
        Template template;
        if(tipo.equalsIgnoreCase("create")){
            template = fmConfiguration.getTemplate("email-template.ftl");
        } else if(tipo.equalsIgnoreCase("update")){
            template = fmConfiguration.getTemplate("email-template.ftl");
        } else {
            template = fmConfiguration.getTemplate("email-template.ftl");
        }

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendEmailWithAddress(PessoaDTO pessoaQueVaiReceberEmail, EnderecoCreateDTO enderecoDTO, String tipo) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            if(tipo == "create"){
                mimeMessageHelper.setSubject("endereco criado");
            } else if (tipo == "update"){
                mimeMessageHelper.setSubject("endereco atualizado");
            } else if (tipo == "delete") {
                mimeMessageHelper.setSubject("endereco deletado");
            } else {
                new RegraDeNegocioException("Erro ao criar, atualizar ou deletar o endereco");
            }
            mimeMessageHelper.setText(geContentFromTemplateWithAddress(pessoaQueVaiReceberEmail,enderecoDTO,tipo), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
    public String geContentFromTemplateWithAddress(PessoaDTO pessoa, EnderecoCreateDTO enderecoDTO, String tipo) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("id", pessoa.getIdPessoa());
        dados.put("email", from);
        Template template;
        if(tipo =="create"){
            template = fmConfiguration.getTemplate("create-email-template.ftl");
        } else if(tipo == "update"){
            template = fmConfiguration.getTemplate("update-email-template.ftl");
        } else {
            template = fmConfiguration.getTemplate("delete-email-template.ftl");
        }
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}