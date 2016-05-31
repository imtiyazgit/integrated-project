import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.VFS;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileCopyTest {

    public static final Map<String, String> SPECIAL_PERCENT_CHAR = new HashMap();
    static {
        SPECIAL_PERCENT_CHAR.put("%","%25");
    }
    public static void main(String[] args) throws Exception {
        // Locate the Jar file
        /*FileSystemManager fsManager = VFS.getManager();
        FileObject jarFile = fsManager.resolveFile( "jar:C:\\Users\\sg0222221\\.m2\\repository\\org\\springframework\\boot\\spring-boot\\1.2.0.RELEASE/spring-boot-1.2.0.RELEASE.jar" );

        // List the children of the Jar file
        FileObject[] children = jarFile.getChildren();
        System.out.println( "Children of " + jarFile.getName().getURI() );
        for ( int i = 0; i < children.length; i++ )
        {
            System.out.println( children[ i ].getName().getBaseName() );
        }*/

        String input = "C:\\ALearning\\IntegratedProject\\spring-basic\\src\\main\\resources\\defaults%.properties";
        input = input.replace("%","%25");

        File file = new File(input);
        if (!file.exists()) {
            System.out.println("Error");
            System.exit(1);
        }

        FileSystemManager fsManager = VFS.getManager();
        FileObject localFile = fsManager.resolveFile(input);
        FileObject remoteFile = fsManager.resolveFile("C:\\ALearning\\IntegratedProject\\spring-basic\\src\\main\\resources\\result.properties");
        remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);

    }


    /*//Code to replace all special characters in the incoming file with '_' symbol.
    private static String checkForSpecialCharsAndGetNewFileName (String originalFileName, String[] splChars, String replaceWith) {
        String newString = originalFileName;
        for (int i=0; i<splChars.length; i++)
            newString = StringUtils.replace(newString, splChars, replaceWith);
        return newString;
    }*/
}
