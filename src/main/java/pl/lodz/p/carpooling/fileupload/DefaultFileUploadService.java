package pl.lodz.p.carpooling.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserRepository;
import pl.lodz.p.carpooling.user.account.Account;

import java.io.IOException;

/**
 * @author Adrian Szwajkowski.
 */
@Service
public class DefaultFileUploadService implements FileUploadService
{
    private static final String CLASSNAME = DefaultFileUploadService.class.getName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CLASSNAME);

    @Value("${file.upload.images.avatars.path}")
    private String avatarsPath;

    @Value("${file.upload.images.avatars.thumbnail.path}")
    private String avatarsThumbnailPath;

    @Value("${file.upload.images.avatars.maxLongSide}")
    private Integer maxLongSide;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public FileUpload uploadFile(FileUpload file) {
        return fileUploadRepository.saveAndFlush(file);
    }

    @Override
    public void saveAvatarFile(MultipartFile file, Account principal) throws IOException {
        String filename = file.getOriginalFilename();
        String userLogin = principal.getLogin();
        LOGGER.debug("Uploading avatar file {} for user {}.", filename, userLogin);

        User user = principal.getUser();
        long updatedUserId = user.getId();
        String avatarFilename = constructAvatarFilename(updatedUserId);
        user.setAvatar(avatarFilename);
        User updatedUser = userRepository.save(user);
        LOGGER.debug("Avatar file {} for user {} saved to database", avatarFilename, userLogin);

        if (updatedUser != null) {
            String avatarPathString = avatarsPath + avatarFilename;
            FileUploadUtil.storeFile(file, avatarPathString);

            String thumbnailPathString = avatarsThumbnailPath + avatarFilename;
            FileUploadUtil.thumbnailImage(avatarPathString, thumbnailPathString, maxLongSide);
        }

        LOGGER.debug("Finished uploading avatar file.");
    }

    private String constructAvatarFilename(long updatedUserId) {
        // TODO
        StringBuffer filenameBuffer = new StringBuffer();
        filenameBuffer.append("avatar");
        filenameBuffer.append(updatedUserId);
        filenameBuffer.append("_1");
        filenameBuffer.append(".gif");
        return filenameBuffer.toString();
    }
}
