package edu.eci.arsw.findeci.services.impl;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import edu.eci.arsw.findeci.Generar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.ImagenesRepository;
import edu.eci.arsw.findeci.services.ImagenesServices;
import edu.eci.arsw.findeci.services.InteresesServices;
import java.io.DataInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenesServicesImpl implements ImagenesServices {

    @Autowired
    ImagenesRepository imagenRepository;

    @Override
    public String saveImage(MultipartFile file) throws FindEciException {
        String ruta = "";

        String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=imagenusuario;AccountKey=qjz2743gHPfAd2EBEfsdV8HkvLHXR7ZhYOnANMCnhOTnk7yI/6zW8YDvpdgF8S+/a3MobKf0Y/pwVmp7ya7b5A==;EndpointSuffix=core.windows.net";
        CloudStorageAccount storageAccount = null;
        CloudBlobContainer container = null;
        URI uriblob = null;
        Long le = file.getSize();
        try {
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        try {
            container = blobClient.getContainerReference("prueba");
        } catch (URISyntaxException ex) {
            Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StorageException ex) {
            Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Listing contents of container
        for (ListBlobItem blobItem : container.listBlobs()) {
            uriblob = blobItem.getUri();
            //System.out.println("URI of blob is: " + blobItem.getUri());
        }

        if (!file.isEmpty()) {
            byte[] bytes;
            try {
                bytes = file.getBytes();

                String nombre = Generar.code() + file.getOriginalFilename();

                Path path = Paths.get(".//src//main//resources//static//img//" + nombre);

                String tipo = file.getContentType();
                InputStream is = null;

                if (tipo != null) {
                    is = new DataInputStream(file.getInputStream());
                    long length = file.getSize();
                    CloudBlockBlob blob = container.getBlockBlobReference("" + nombre);
                    blob.upload(is, length);
                }

                switch (tipo) {
                    case "image/png":
                        Files.write(path, bytes);
                        ruta = "/img/" + nombre;
                        break;
                    case "image/jpg":
                        Files.write(path, bytes);
                        ruta = "/img/" + nombre;
                        break;
                    case "image/jpeg":
                        Files.write(path, bytes);
                        ruta = "/img/" + nombre;
                        break;
                    case "image/gif":
                        Files.write(path, bytes);
                        ruta = "/img/" + nombre;
                        break;
                    default:
                        ruta = "";
                        break;
                }
            } catch (IOException ex) {
                ruta = "";
            } catch (URISyntaxException ex) {
                Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (StorageException ex) {
                Logger.getLogger(ImagenesServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ruta;
    }

    @Override
    public Imagenes findImageByCorreo(String correo) throws FindEciException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Imagenes> find(Pageable page) {
        return imagenRepository.findAll(page).getContent();
    }

    @Override
    public void guardarImg(String titulo, String ruta) throws FindEciException {
        Imagenes img = new Imagenes();
        img.setRuta(ruta);
        img.setTitulo(titulo);
        img.setFecha(new Date());
        imagenRepository.save(img);
    }

}
