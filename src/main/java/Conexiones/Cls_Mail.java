package Conexiones;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Cls_Mail {

    private String us;
    private String con;
    private String emp;

    public void sendMail(String recepient, String emp, String us, String con) throws Exception {
        this.emp = emp;
        this.us = us;
        this.con = con;

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String cuenta = "clinicaveterinaria504@gmail.com";
        String contra = "Veterin@rio504";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(cuenta, contra);
            }
        });

        Message message = prepareMessage(session, cuenta, recepient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private Message prepareMessage(Session session, String cuenta, String recepient) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(cuenta));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Recuperación de usuario y contraseña");
            message.setContent(devolverHTML(), "text/html");

            return message;
        } catch (Exception e) {
            Logger.getLogger(Cls_Mail.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private String devolverHTML() {
        String htmlCode = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en-GB\">\n"
                + "<head>\n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "  <title>Demystifying Email Design</title>\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                + "\n"
                + "  <style type=\"text/css\">\n"
                + "    a[x-apple-data-detectors] {color: inherit !important;}\n"
                + "  </style>\n"
                + "\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0;\">\n"
                + "  <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                + "    <tr>\n"
                + "      <td style=\"padding: 20px 0 30px 0;\">\n"
                + "\n"
                + "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; border: 1px solid #cccccc;\">\n"
                + "  <tr>\n"
                + "    <td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">\n"
                + "      <img src=\"https://1.bp.blogspot.com/-s7F0NdJfbi8/Uy9wzUS4soI/AAAAAAAAAV0/_NV-9yv77f0/s1600/allAnimals.gif\" alt=\"Los mejores veterinarios de HN\" width=\"300\" height=\"230\" style=\"display: block;\" />\n"
                + "    </td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\n"
                + "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n"
                + "        <tr>\n"
                + "          <td style=\"color: #153643; font-family: Arial, sans-serif;\">\n"
                + "            <h1 style=\"font-size: 24px; margin: 0;\">Clínica Veterinaria</h1>\n"
                + "          </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "          <td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 24px; padding: 20px 0 30px 0;\">\n"
                + "            <p style=\"margin: 0;\">Estimado empleado: " + this.emp + "\n"
                + "            <br>Se ha solicitado una recuperación de tu usuario y contraseña desde el sistema local, aquí te estaremos enviado la información solicitada.\n"
                + "            Si no fuiste tu quien solicitó la información por favor comunicale al gerente encargado e ignora este correo.\n"
                + "            \n"
                + "            </p>\n"
                + "          </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "          <td>\n"
                + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n"
                + "              <tr>\n"
                + "                <td width=\"260\" valign=\"top\">\n"
                + "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n"
                + "                    <tr>\n"
                + "                      <td>\n"
                + "                        <img src=\"https://pueblaroja.mx/wp-content/uploads/2017/07/cada-cuanto-tiempo-hay-que-llevar-perro-al-veterinario.jpg\" alt=\"\" width=\"100%\" height=\"180\" style=\"display: block;\" />\n"
                + "                      </td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                      <td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 24px; padding: 25px 0 0 0;\">\n"
                + "                        <p style=\"margin: 0;\">\n"
                + "                            Usuario: " + this.us + "\n"
                + "                            <br>\n"
                + "                            Contraseña: " + this.con + "\n"
                + "                        </p>\n"
                + "                      </td>\n"
                + "                    </tr>\n"
                + "                  </table>\n"
                + "                </td>\n"
                + "                <td style=\"font-size: 0; line-height: 0;\" width=\"20\">&nbsp;</td>\n"
                + "                <td width=\"260\" valign=\"top\">\n"
                + "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n"
                + "                    <tr>\n"
                + "                      <td>\n"
                + "                        <img src=\"https://th.bing.com/th/id/OIP.-9aoRhJ9F2mGtG-W0nydBQHaHa?pid=Api&rs=1\" alt=\"\" width=\"100%\" height=\"180\" style=\"display: block;\" />\n"
                + "                      </td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                      <td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 24px; padding: 25px 0 0 0;\">\n"
                + "                        <p style=\"margin: 0;\">\n"
                + "                        Integrantes:\n"
                + "                        <br>Daniel Arias\n"
                + "                        <br>Kenia Martínez\n"
                + "                        <br>Kevin Martínez\n"
                + "                        <br>Oscar Andrade\n"
                + "                        <br>Walter Amador\n"
                + "                        </p>\n"
                + "                      </td>\n"
                + "                    </tr>\n"
                + "                  </table>\n"
                + "                </td>\n"
                + "              </tr>\n"
                + "            </table>\n"
                + "          </td>\n"
                + "        </tr>\n"
                + "      </table>\n"
                + "    </td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td bgcolor=\"#ee4c50\" style=\"padding: 30px 30px;\">\n"
                + "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n"
                + "        <tr>\n"
                + "          <p>\n"
                + "              Muchas gracias por su atención\n"
                + "              <br>Proyecto Final\n"
                + "              <br>Programación Multiplataforma\n"
                + "              <br>Tercer Parcial 2020\n"
                + "          </p>\n"
                + "          <td align=\"right\">\n"
                + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;\">\n"
                + "              <tr>\n"
                + "                <td>\n"
                + "                  <a href=\"http://www.twitter.com/\">\n"
                + "                    <img src=\"https://assets.codepen.io/210284/tw.gif\" alt=\"Twitter.\" width=\"38\" height=\"38\" style=\"display: block;\" border=\"0\" />\n"
                + "                  </a>\n"
                + "                </td>\n"
                + "                <td style=\"font-size: 0; line-height: 0;\" width=\"20\">&nbsp;</td>\n"
                + "                <td>\n"
                + "                  <a href=\"http://www.Facebook.com/\">\n"
                + "                    <img src=\"https://assets.codepen.io/210284/fb.gif\" alt=\"Facebook.\" width=\"38\" height=\"38\" style=\"display: block;\" border=\"0\" />\n"
                + "                  </a>\n"
                + "                </td>\n"
                + "              </tr>\n"
                + "            </table>\n"
                + "          </td>\n"
                + "        </tr>\n"
                + "      </table>\n"
                + "    </td>\n"
                + "  </tr>\n"
                + "</table>\n"
                + "\n"
                + "      </td>\n"
                + "    </tr>\n"
                + "  </table>\n"
                + "</body>\n"
                + "</html>";
        
        return htmlCode;
    }
}
