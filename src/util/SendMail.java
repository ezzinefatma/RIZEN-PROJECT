/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import model.User;



/**
 *
 * @author Fatma
 */
public class SendMail {
    
   
    
    
          
            
    public static void send(String recepient,int mot) throws MessagingException 
            
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="rizen.application@gmail.com";
        String password ="rizenapp";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessage(session,myAccountEmail,recepient,mot);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,int mot) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reset Password");
            String pass="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n" +
" <head> \n" +
"  <meta charset=\"UTF-8\"> \n" +
"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
"  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
"  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
"  <title>Nouveau modC3A8le de courrier C3A9lectronique 2022-03-09</title><!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"    a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
"<xml>\n" +
"    <o:OfficeDocumentSettings>\n" +
"    <o:AllowPNG></o:AllowPNG>\n" +
"    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"    </o:OfficeDocumentSettings>\n" +
"</xml>\n" +
"<![endif]--><!--[if !mso]><!-- --> \n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]--> \n" +
"  <style type=\"text/css\">\n" +
"#outlook a {\n" +
"	padding:0;\n" +
"}\n" +
".ExternalClass {\n" +
"	width:100%;\n" +
"}\n" +
".ExternalClass,\n" +
".ExternalClass p,\n" +
".ExternalClass span,\n" +
".ExternalClass font,\n" +
".ExternalClass td,\n" +
".ExternalClass div {\n" +
"	line-height:100%;\n" +
"}\n" +
".es-button {\n" +
"	mso-style-priority:100!important;\n" +
"	text-decoration:none!important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color:inherit!important;\n" +
"	text-decoration:none!important;\n" +
"	font-size:inherit!important;\n" +
"	font-family:inherit!important;\n" +
"	font-weight:inherit!important;\n" +
"	line-height:inherit!important;\n" +
"}\n" +
".es-desk-hidden {\n" +
"	display:none;\n" +
"	float:left;\n" +
"	overflow:hidden;\n" +
"	width:0;\n" +
"	max-height:0;\n" +
"	line-height:0;\n" +
"	mso-hide:all;\n" +
"}\n" +
"[data-ogsb] .es-button {\n" +
"	border-width:0!important;\n" +
"	padding:15px 25px 15px 25px!important;\n" +
"}\n" +
"@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-width:15px 25px 15px 25px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
"</style> \n" +
" </head> \n" +
" <body style=\"width:100%;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n" +
"  <div class=\"es-wrapper-color\" style=\"background-color:#F4F4F4\"><!--[if gte mso 9]>\n" +
"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"				<v:fill type=\"tile\" color=\"#f4f4f4\"></v:fill>\n" +
"			</v:background>\n" +
"		<![endif]--> \n" +
"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \n" +
"     <tr class=\"gmail-fix\" height=\"0\" style=\"border-collapse:collapse\"> \n" +
"      <td style=\"padding:0;Margin:0\"> \n" +
"       <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:600px\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"padding:0;Margin:0;line-height:1px;min-width:600px\" height=\"0\"><img src=\"https://kglzht.stripocdn.email/content/guids/CABINET_837dc1d79e3a5eca5eb1609bfe9fd374/images/41521605538834349.png\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;max-height:0px;min-height:0px;min-width:600px;width:600px\" alt width=\"600\" height=\"1\"></td> \n" +
"         </tr> \n" +
"       </table></td> \n" +
"     </tr> \n" +
"     <tr style=\"border-collapse:collapse\"> \n" +
"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \n" +
"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:15px;padding-bottom:15px\"><!--[if mso]><table style=\"width:580px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:282px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td align=\"left\" style=\"padding:0;Margin:0;width:282px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica\\ neue', helvetica, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\">Put your preheader text here<br></p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:278px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td align=\"left\" style=\"padding:0;Margin:0;width:278px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"right\" class=\"es-infoblock es-m-txt-c\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\"><a href=\"https://viewstripo.email\" class=\"view\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif\">View in browser</a></p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table><!--[if mso]></td></tr></table><![endif]--></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:#7C72DC;background-repeat:repeat;background-position:center top\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td style=\"padding:0;Margin:0;background-color:#7c72dc\" bgcolor=\"#7c72dc\" align=\"center\"> \n" +
"           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#7C72DC;width:600px\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:580px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://kglzht.stripocdn.email/content/guids/3711d794-3a86-4bbc-92d7-6353bed6bf81/images/rizen.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"140\"></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td style=\"padding:0;Margin:0;background-color:#7c72dc\" bgcolor=\"#7c72dc\" align=\"center\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#ffffff;border-radius:4px\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-bottom:5px;padding-left:30px;padding-right:30px;padding-top:35px\"><h1 style=\"Margin:0;line-height:58px;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;font-size:48px;font-style:normal;font-weight:normal;color:#111111\">Reset your Password</h1></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td bgcolor=\"#ffffff\" align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:20px;padding-right:20px;font-size:0\"> \n" +
"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #ffffff;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\"></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#ffffff;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#ffffff\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-m-txt-l\" bgcolor=\"#ffffff\" align=\"left\" style=\"Margin:0;padding-bottom:15px;padding-top:20px;padding-left:30px;padding-right:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px;text-align:justify\">Resetting your password is easy. Just enter the verification code&nbsp;below and follow the instructions. We'll have you up and running in no time.</p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:30px;padding-right:30px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:540px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:40px;padding-bottom:40px\"><span class=\"es-button-border\" style=\"border-style:solid;border-color:#7C72DC;background:#7C72DC;border-width:1px;display:inline-block;border-radius:2px;width:auto\"><a href=\"https://viewstripo.email/\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:20px;border-style:solid;border-color:#7C72DC;border-width:15px 25px 15px 25px;display:inline-block;background:#7C72DC;border-radius:2px;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;font-weight:normal;font-style:normal;line-height:24px;width:auto;text-align:center\">Verification Code</a></span></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:4px;background-color:#111111\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#111111\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-m-txt-l\" bgcolor=\"#111111\" align=\"left\" style=\"padding:0;Margin:0;padding-left:30px;padding-right:30px;padding-top:35px\"><h2 style=\"Margin:0;line-height:29px;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;font-size:24px;font-style:normal;font-weight:normal;color:#ffffff\">Want a more secure account?<br></h2></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-m-txt-l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:30px;padding-right:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:27px;color:#666666;font-size:18px\">We support two-factor authentication to help keep your information private.<br></p></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td esdev-links-color=\"#7c72dc\" align=\"left\" style=\"Margin:0;padding-top:20px;padding-left:30px;padding-right:30px;padding-bottom:40px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#7c72dc;font-size:18px\">See how easy it is to get started</a></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-top:10px;padding-bottom:20px;padding-left:20px;padding-right:20px;font-size:0\"> \n" +
"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #f4f4f4;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\"></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#c6c2ed;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#c6c2ed\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:4px\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px\"><h3 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;font-style:normal;font-weight:normal;color:#111111\">Need more help?</h3></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td esdev-links-color=\"#7c72dc\" align=\"center\" style=\"padding:0;Margin:0;padding-bottom:30px;padding-left:30px;padding-right:30px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#7c72dc;font-size:18px\">We’re here, ready to talk</a></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:30px;padding-bottom:30px;padding-left:30px;padding-right:30px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:540px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-top:25px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#666666;font-size:14px\">If these emails get annoying, please feel free to&nbsp;<strong><a target=\"_blank\" class=\"unsubscribe\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#111111;font-size:14px\">unsubscribe</a></strong>.</p></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-top:25px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lato, 'helvetica neue', helvetica, arial, sans-serif;line-height:17px;color:#666666;font-size:14px;text-align:center\">2021 | RIZEN&nbsp;</p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table></td> \n" +
"     </tr> \n" +
"   </table> \n" +
"  </div>  \n" +
" </body>\n" +
"</html>";
           
         
           message.setContent(pass,"text/html");
            return message;
    }
        
   public static void sendSignUp(String recepient) throws MessagingException 
            
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="rizen.application@gmail.com";
        String password ="rizenapp";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessage(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("RIZEN TEAM");
            String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n" +
" <head> \n" +
"  <meta charset=\"UTF-8\"> \n" +
"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
"  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
"  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
"  <title>Nouveau modC3A8le de courrier C3A9lectronique 2022-03-09</title><!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"    a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
"<xml>\n" +
"    <o:OfficeDocumentSettings>\n" +
"    <o:AllowPNG></o:AllowPNG>\n" +
"    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"    </o:OfficeDocumentSettings>\n" +
"</xml>\n" +
"<![endif]--><!--[if !mso]><!-- --> \n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]--> \n" +
"  <style type=\"text/css\">\n" +
"#outlook a {\n" +
"	padding:0;\n" +
"}\n" +
".ExternalClass {\n" +
"	width:100%;\n" +
"}\n" +
".ExternalClass,\n" +
".ExternalClass p,\n" +
".ExternalClass span,\n" +
".ExternalClass font,\n" +
".ExternalClass td,\n" +
".ExternalClass div {\n" +
"	line-height:100%;\n" +
"}\n" +
".es-button {\n" +
"	mso-style-priority:100!important;\n" +
"	text-decoration:none!important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color:inherit!important;\n" +
"	text-decoration:none!important;\n" +
"	font-size:inherit!important;\n" +
"	font-family:inherit!important;\n" +
"	font-weight:inherit!important;\n" +
"	line-height:inherit!important;\n" +
"}\n" +
".es-desk-hidden {\n" +
"	display:none;\n" +
"	float:left;\n" +
"	overflow:hidden;\n" +
"	width:0;\n" +
"	max-height:0;\n" +
"	line-height:0;\n" +
"	mso-hide:all;\n" +
"}\n" +
"[data-ogsb] .es-button {\n" +
"	border-width:0!important;\n" +
"	padding:10px 20px 10px 20px!important;\n" +
"}\n" +
"@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:inline-block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
"</style> \n" +
" </head> \n" +
" <body style=\"width:100%;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n" +
"  <div class=\"es-wrapper-color\" style=\"background-color:#FFFFFF\"><!--[if gte mso 9]>\n" +
"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"				<v:fill type=\"tile\" color=\"#ffffff\"></v:fill>\n" +
"			</v:background>\n" +
"		<![endif]--> \n" +
"   <table class=\"es-wrapper\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"> \n" +
"     <tr style=\"border-collapse:collapse\"> \n" +
"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \n" +
"       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-header-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://uglzfp.stripocdn.email/content/guids/61aafb71-e3d3-47ea-9fef-4cf65a43e457/images/rizen.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"140\"></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:3px;background-color:#fcfcfc\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fcfcfc\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-m-txt-l\" align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><h2 style=\"Margin:0;line-height:31px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:26px;font-style:normal;font-weight:normal;color:#dda0dd\"><strong>Welcome!</strong></h2></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td bgcolor=\"#fcfcfc\" align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-right:20px;padding-left:25px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:24px;color:#333333;font-size:16px\">We are&nbsp;thrilled that you are here!&nbsp;</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:24px;color:#333333;font-size:16px\">Now that you’re an official subscriber, you’ll get list of your specific benefits here like exclusive content, early access to deals, priority registration, sneak peeks at new arrivals, helpful tips and inside information.<br><br></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:21px;color:#333333;font-size:14px\">Feel free to drop me a line if you have any questions!&nbsp;</p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#fff4f7\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fff4f7\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-bottom:5px;padding-top:20px;padding-left:20px;padding-right:20px\"><h3 style=\"Margin:0;line-height:22px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:18px;font-style:normal;font-weight:normal;color:#333333\">Let's get social</h3></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td style=\"padding:0;Margin:0;background-color:#666666\" bgcolor=\"#666666\" align=\"center\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#fff4f7;border-radius:3px\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fff4f7\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td bgcolor=\"#fff4f7\" align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:20px;padding-right:20px;font-size:0\"> \n" +
"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #fff4f7;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\"></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-top:5px;padding-left:20px;padding-right:20px;padding-bottom:25px;font-size:0\"> \n" +
"                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#F6A1B4;font-size:14px\"><img title=\"Facebook\" src=\"https://uglzfp.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \n" +
"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#F6A1B4;font-size:14px\"><img title=\"Twitter\" src=\"https://uglzfp.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \n" +
"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#F6A1B4;font-size:14px\"><img title=\"Instagram\" src=\"https://uglzfp.stripocdn.email/content/assets/img/social-icons/logo-black/instagram-logo-black.png\" alt=\"Inst\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \n" +
"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#F6A1B4;font-size:14px\"><img title=\"Youtube\" src=\"https://uglzfp.stripocdn.email/content/assets/img/social-icons/logo-black/youtube-logo-black.png\" alt=\"Yt\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td style=\"padding:0;Margin:0;background-color:#666666\" bgcolor=\"#666666\" align=\"center\"> \n" +
"           <table class=\"es-footer-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#666666;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#666666\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td esdev-links-color=\"#999999\" align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:21px;color:#ffffff;font-size:14px\">You are receiving this email because you asked us about regular newsletter.</p></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:21px;color:#ffffff;font-size:14px\">You can <a class=\"unsubscribe\" target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#F6A1B4;font-size:14px\">unsubscribe</a> from these emails.</p></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td esdev-links-color=\"#999999\" align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:helvetica, 'helvetica neue', arial, verdana, sans-serif;line-height:21px;color:#ffffff;font-size:14px\">2021 | RIZEN&nbsp;</p></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table></td> \n" +
"     </tr> \n" +
"   </table> \n" +
"  </div>  \n" +
" </body>\n" +
"</html>";
            message.setContent(msg,"text/html");
            return message;
    }
        
       
}
