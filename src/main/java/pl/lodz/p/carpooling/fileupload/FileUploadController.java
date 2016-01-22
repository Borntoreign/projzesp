package pl.lodz.p.carpooling.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pl.lodz.p.carpooling.security.AccountUserDetails;
import pl.lodz.p.carpooling.user.account.Account;

import java.util.Iterator;

/**
 * @author Adrian Szwajkowski.
 */
@Controller
public class FileUploadController
{
    private static final String CLASSNAME = DefaultFileUploadService.class.getName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CLASSNAME);

    @Autowired
    private DefaultFileUploadService defaultFileUploadService;

    @RequestMapping(value = "/upload/avatar", method = RequestMethod.POST)
    public ResponseEntity uploadAvatarFile(MultipartHttpServletRequest request, Authentication authentication) {
        try {
            Iterator<String> fileNamesIterator = request.getFileNames();
            while (fileNamesIterator.hasNext()) {
                String uploadedFile = fileNamesIterator.next();
                MultipartFile avatar = request.getFile(uploadedFile);
                AccountUserDetails accountUserDetails = (AccountUserDetails) authentication.getPrincipal();
                Account account = accountUserDetails.getAccount();
                defaultFileUploadService.saveAvatarFile(avatar, account);
            }
        }
        catch (Exception e) {
            LOGGER.debug("Avatar file uploading failed: " + e.getLocalizedMessage(), e);
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
