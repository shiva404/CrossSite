package com.intuit.test;

import com.intuit.test.commons.TestBase;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 5/21/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebTest extends TestBase {
    @Test
    public void testFileUpload(){
        File imageFile = new File("/Users/sn1/CrossSite1/files/image.jpg");
        resource.path("web/stream").header("Content-Type", "multipart/form-data").entity(imageFile).put();

        File pdfFile =  new File("/Users/sn1/CrossSite1/files/lokpal.pdf");
    //    resource.path("web/1/documentFragments/1").header("Content-Type", "application/pdf").entity(pdfFile).put();

        File pngImage = new File("/Users/sn1/CrossSite1/files/ScreenShot.pdf");
      //  resource.path("web/1/documentFragments/1").header("Content-Type", "application/png").entity(pngImage).put();
    }

    @Test
    public void testFileUploadMultipart(){
        File imageFile = new File("/Users/sn1/CrossSite1/files/image.jpg");
        resource.path("web/multipartConsumesMultipart").header("Content-Type", "multipart/form-data").entity(imageFile).put();

        File pdfFile =  new File("/Users/sn1/CrossSite1/files/lokpal.pdf");
        //    resource.path("web/1/documentFragments/1").header("Content-Type", "application/pdf").entity(pdfFile).put();

        File pngImage = new File("/Users/sn1/CrossSite1/files/ScreenShot.pdf");
        //  resource.path("web/1/documentFragments/1").header("Content-Type", "application/png").entity(pngImage).put();
    }

}
