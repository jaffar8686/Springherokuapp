package com.example.heroku.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Async
    public void sendEmail(String  text){

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

            String html1 = "<html><body><h5>Welcome</h5></body></html>";
            String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                    "<head>\n" +
                    "<!--[if gte mso 9]>\n" +
                    "<xml>\n" +
                    "  <o:OfficeDocumentSettings>\n" +
                    "    <o:AllowPNG/>\n" +
                    "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                    "  </o:OfficeDocumentSettings>\n" +
                    "</xml>\n" +
                    "<![endif]-->\n" +
                    "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                    "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                    "  <title></title>\n" +
                    "  \n" +
                    "    <style type=\"text/css\">\n" +
                    "      @media only screen and (min-width: 620px) {\n" +
                    "  .u-row {\n" +
                    "    width: 600px !important;\n" +
                    "  }\n" +
                    "  .u-row .u-col {\n" +
                    "    vertical-align: top;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-33p33 {\n" +
                    "    width: 199.98px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-100 {\n" +
                    "    width: 600px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width: 620px) {\n" +
                    "  .u-row-container {\n" +
                    "    max-width: 100% !important;\n" +
                    "    padding-left: 0px !important;\n" +
                    "    padding-right: 0px !important;\n" +
                    "  }\n" +
                    "  .u-row .u-col {\n" +
                    "    min-width: 320px !important;\n" +
                    "    max-width: 100% !important;\n" +
                    "    display: block !important;\n" +
                    "  }\n" +
                    "  .u-row {\n" +
                    "    width: calc(100% - 40px) !important;\n" +
                    "  }\n" +
                    "  .u-col {\n" +
                    "    width: 100% !important;\n" +
                    "  }\n" +
                    "  .u-col > div {\n" +
                    "    margin: 0 auto;\n" +
                    "  }\n" +
                    "}\n" +
                    "body {\n" +
                    "  margin: 0;\n" +
                    "  padding: 0;\n" +
                    "}\n" +
                    "\n" +
                    "table,\n" +
                    "tr,\n" +
                    "td {\n" +
                    "  vertical-align: top;\n" +
                    "  border-collapse: collapse;\n" +
                    "}\n" +
                    "\n" +
                    "p {\n" +
                    "  margin: 0;\n" +
                    "}\n" +
                    "\n" +
                    ".ie-container table,\n" +
                    ".mso-container table {\n" +
                    "  table-layout: fixed;\n" +
                    "}\n" +
                    "\n" +
                    "* {\n" +
                    "  line-height: inherit;\n" +
                    "}\n" +
                    "\n" +
                    "a[x-apple-data-detectors='true'] {\n" +
                    "  color: inherit !important;\n" +
                    "  text-decoration: none !important;\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width: 480px) {\n" +
                    "  .hide-mobile {\n" +
                    "    max-height: 0px;\n" +
                    "    overflow: hidden;\n" +
                    "    display: none !important;\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_text_2 a { color: #f1c40f; } @media (max-width: 480px) { #u_content_heading_1 .v-font-size { font-size: 26px !important; } #u_content_text_15 .v-container-padding-padding { padding: 0px 10px 10px !important; } #u_content_button_1 .v-size-width { width: 55% !important; } #u_content_image_1 .v-container-padding-padding { padding: 50px 0px 40px !important; } #u_content_text_1 .v-container-padding-padding { padding: 0px 10px 10px !important; } #u_content_image_2 .v-container-padding-padding { padding: 20px 10px 0px !important; } #u_content_image_2 .v-src-width { width: auto !important; } #u_content_image_2 .v-src-max-width { max-width: 20% !important; } #u_content_text_10 .v-container-padding-padding { padding: 20px 10px 0px !important; } #u_content_image_4 .v-container-padding-padding { padding: 0px 10px !important; } #u_content_image_4 .v-src-width { width: auto !important; } #u_content_image_4 .v-src-max-width { max-width: 20% !important; } #u_content_text_12 .v-container-padding-padding { padding: 20px 10px 0px !important; } #u_content_image_3 .v-src-width { width: auto !important; } #u_content_image_3 .v-src-max-width { max-width: 17% !important; } #u_content_text_2 .v-container-padding-padding { padding: 80px 10px 10px !important; } #u_content_menu_1 .v-padding { padding: 5px 10px !important; } }\n" +
                    "    </style>\n" +
                    "  \n" +
                    "  \n" +
                    "\n" +
                    "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Rubik:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                    "\n" +
                    "</head>\n" +
                    "\n" +
                    "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e7e7e7;color: #000000\">\n" +
                    "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                    "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                    "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e7e7e7;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                    "  <tbody>\n" +
                    "  <tr style=\"vertical-align: top\">\n" +
                    "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #e7e7e7;\"><![endif]-->\n" +
                    "    \n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-image: url('cid:backgroundImage');background-repeat: no-repeat;background-position: center top;background-color: transparent\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-image: url('cid:backgroundImage');background-repeat: no-repeat;background-position: center top;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_heading_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:80px 10px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 110%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 35px;\">\n" +
                    "    <div>\n" +
                    "<div>\n" +
                    "<div><strong>Scheduler runs  <br />  "+text+" </strong></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_15\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 45px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">"+text+"</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_button_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\n" +
                    "<div align=\"center\">\n" +
                    "  <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.unlayer.com\" style=\"height:37px; v-text-anchor:middle; width:186px;\" arcsize=\"67.5%\"  stroke=\"f\" fillcolor=\"#333333\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:'Open Sans',sans-serif;\"><![endif]-->  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_blank\" class=\"v-button v-size-width\" style=\"box-sizing: border-box;display: inline-block;font-family:'Open Sans',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #333333; border-radius: 25px;-webkit-border-radius: 25px; -moz-border-radius: 25px; width:32%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\n" +
                    "      <span class=\"v-padding\" style=\"display:block;padding:10px 20px;line-height:120%;\"><strong><span style=\"font-size: 14px; line-height: 16.8px;\">Welcome</span></strong></span>\n" +
                    "    </a>\n" +
                    "  <!--[if mso]></center></v:roundrect><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_image_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:80px 0px 40px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"cid:GIFF\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 92%;max-width: 552px;\" width=\"552\" class=\"v-src-width v-src-max-width\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #edd8eb\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #edd8eb;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #edd8eb;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"background-color: #edd8eb;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 30px;\">\n" +
                    "    <div>\n" +
                    "<div><strong>Technologies</strong></div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 45px 60px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 170%;\">Spring boot application deploy on Heroku Cloud triggers email </p>\n" +
                    "<p style=\"font-size: 14px; line-height: 170%;\">"+text+".</p>\n" +
                    "<p style=\"font-size: 14px; line-height: 170%;\">This email template can be get from unlayer website.</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #edd8eb\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #edd8eb;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"width: 200px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div st" +
                    "" +
                    "yle=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_2\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"cid:spring\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 69%;max-width: 124.2px;\" width=\"124.2\" class=\"v-src-width v-src-max-width\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_10\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 16px; line-height: 22.4px; font-family: Rubik, sans-serif;\"><strong>Spring Boot</strong></span></p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"width: 200px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_4\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"cid:heroku\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 80%;max-width: 144px;\" width=\"144\" class=\"v-src-width v-src-max-width\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_12\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"line-height: 140%; font-size: 14px;\"><span style=\"font-family: Rubik, sans-serif;\"><span style=\"font-size: 16px; line-height: 22.4px;\"><strong>Heroku </strong></span></span></p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"width: 200px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_3\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"cid:unlayer\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 57%;max-width: 102.6px;\" width=\"102.6\" class=\"v-src-width v-src-max-width\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 16px; line-height: 22.4px; font-family: Rubik, sans-serif;\"><strong>Unlayer</strong></span></p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #333333\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #333333;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #333333;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"background-color: #333333;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_text_2\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:80px 50px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div style=\"color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">if you have any questions, please email us at <a rel=\"noopener\" href=\"https://www.unlayer.com\" target=\"_blank\">www.google.com</a> or visit our FAQS, you can also chat with a reel live human during our operating hours. They can answer questions about your account</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"56%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #7e8c8d;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                    "    <tbody>\n" +
                    "      <tr style=\"vertical-align: top\">\n" +
                    "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                    "          <span>&#160;</span>\n" +
                    "        </td>\n" +
                    "      </tr>\n" +
                    "    </tbody>\n" +
                    "  </table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div align=\"center\">\n" +
                    "  <div style=\"display: table; max-width:187px;\">\n" +
                    "  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\n" +
                    "  \n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
                    "          <img src=\"cid:facebook\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\n" +
                    "          <img src=\"cid:twitter\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
                    "          <img src=\"cid:instagram\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://pinterest.com/\" title=\"Pinterest\" target=\"_blank\">\n" +
                    "          <img src=\"cid:pinterest\" alt=\"Pinterest\" title=\"Pinterest\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_menu_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div class=\"menu\" style=\"text-align:center\">\n" +
                    "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                    "      Home\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px\" class=\"v-padding v-font-size hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                    "      Page\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px\" class=\"v-padding v-font-size hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                    "      About Us\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px\" class=\"v-padding v-font-size hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:arial,helvetica,sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                    "      Contact Us\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "  </tbody>\n" +
                    "  </table>\n" +
                    "  <!--[if mso]></div><![endif]-->\n" +
                    "  <!--[if IE]></div><![endif]-->\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n";

            mimeMessageHelper.setText(html,true);
            ClassPathResource resource = new ClassPathResource("/static/images/image-5.png");
            mimeMessageHelper.addInline("backgroundImage", resource);

            ClassPathResource resource1 = new ClassPathResource("static/images/image-9.gif");
            mimeMessageHelper.addInline("GIFF", resource1);

            ClassPathResource resource2 = new ClassPathResource("static/images/image-6.png");
            mimeMessageHelper.addInline("spring", resource2);

            ClassPathResource resource3 = new ClassPathResource("static/images/image-8.png");
            mimeMessageHelper.addInline("heroku", resource3);

            ClassPathResource resource4 = new ClassPathResource("static/images/image-7.png");
            mimeMessageHelper.addInline("unlayer", resource4);

            ClassPathResource resource5 = new ClassPathResource("static/images/image-3.png");
            mimeMessageHelper.addInline("facebook", resource5);

            ClassPathResource resource6 = new ClassPathResource("static/images/image-1.png");
            mimeMessageHelper.addInline("twitter", resource6);

            ClassPathResource resource7 = new ClassPathResource("static/images/image-2.png");
            mimeMessageHelper.addInline("instagram", resource7);

            ClassPathResource resource8 = new ClassPathResource("static/images/image-4.png");
            mimeMessageHelper.addInline("pinterest", resource8);

            mimeMessageHelper.setSubject(text);
            mimeMessageHelper.setTo("mohammedjaff1999@gmail.com");


            javaMailSender.send(mimeMessage);

            logger.info("Email send successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
