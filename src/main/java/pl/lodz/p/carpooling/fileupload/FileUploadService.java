package pl.lodz.p.carpooling.fileupload;

import org.springframework.web.multipart.MultipartFile;
import pl.lodz.p.carpooling.user.account.Account;

import java.io.IOException;

/**
 * @author Adrian Szwajkowski.
 */
public interface FileUploadService
{
    FileUpload uploadFile(FileUpload file);

    void saveAvatarFile(MultipartFile file, Account principal) throws IOException;
}
