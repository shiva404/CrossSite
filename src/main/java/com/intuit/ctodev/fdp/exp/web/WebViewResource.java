package com.intuit.ctodev.fdp.exp.web;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.UUID;

public class WebViewResource implements IWebViewResource {

    @Override
    public Response index() {
        return Response.ok(new Viewable("/index.jsp")).build();
    }

    @Override
    public Response fileUploadStream( Request request, InputStream inputStream) {
        try{

        File rootFolder = new File ("files");
        if(!rootFolder.exists()){
            rootFolder.mkdir();
        }
        File destFile = new File( rootFolder.getAbsolutePath() + "/" + UUID.randomUUID() + ".JPG ");
        if(!destFile.exists()){
            destFile.createNewFile();
            System.out.println(destFile.getAbsoluteFile() + "file created");
        }


            OutputStream outputStream = null;

            try {
                // write the inputStream to a FileOutputStream
                outputStream =
                        new FileOutputStream(destFile);

                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                System.out.println("Done!");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    try {
                        // outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }


        } catch (Exception e){

            e.printStackTrace();
        }
        return Response.ok().build();

    }

    public Response fileUploadWithMultiPart(Request request, InputStream uploadedInputStream,
                                            FormDataContentDisposition fileDetail) {

        try{


        File rootFolder = new File ("files");
        if(!rootFolder.exists()){
            rootFolder.mkdir();
        }
        File destFile = new File( rootFolder.getAbsolutePath() + "/" + UUID.randomUUID() + ".JPG ");
        if(!destFile.exists()){
            destFile.createNewFile();
            System.out.println(destFile.getAbsoluteFile() + "file created");
        }

        // save it
        writeToFile(uploadedInputStream, destFile);

        String output = "File uploaded to : " + destFile;



        }catch (Exception e){

            e.printStackTrace();
        }
        return Response.status(200).build();
    }

  //  @Override
    public Response fileUploadWithConsumesMultiPart(Request request,InputStream uploadedInputStream,
                                                    FormDataContentDisposition fileDetail){
        try{


            File rootFolder = new File ("files");
            if(!rootFolder.exists()){
                rootFolder.mkdir();
            }
            File destFile = new File( rootFolder.getAbsolutePath() + "/" + UUID.randomUUID() + ".JPG ");
            if(!destFile.exists()){
                destFile.createNewFile();
                System.out.println(destFile.getAbsoluteFile() + "file created");
            }

            // save it
            writeToFile(uploadedInputStream, destFile);

            String output = "File uploaded to : " + destFile;



        }catch (Exception e){

            e.printStackTrace();
        }
        return Response.status(200).build();
    }

    @Override
    public Response hello() {

        System.out.println("Got it bitch !!");

        return Response.ok().build();

    }

    @Override
    public Response uploadFile() {
        return null;
    }

    private void writeToFile(InputStream uploadedInputStream,
                             File destFile) {

        try {
            OutputStream out;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(destFile);
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


}
