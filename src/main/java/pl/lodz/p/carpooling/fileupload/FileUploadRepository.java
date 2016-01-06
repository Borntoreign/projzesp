package pl.lodz.p.carpooling.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian Szwajkowski.
 */
@Repository
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>
{
    FileUpload findByFilename(String filename);
}