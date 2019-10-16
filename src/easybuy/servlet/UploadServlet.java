package easybuy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        拿到file对象
        Part part = req.getPart("files");

        //拿后缀名
        //header:  form-data; name="files"; filename="5b3fe4e9ee1c817348bba1c70358a28.jpg"
        String header = part.getHeader("content-disposition");
        String suffix = header.substring(header.lastIndexOf("."), header.length()-1);
        String filename = UUID.randomUUID()+suffix;

        String path = req.getServletContext().getRealPath("/upload");
        String fullFilename = path + "/" + filename;

        InputStream is = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(fullFilename);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b))!=-1){
            fos.write(b, 0, len);
        }

        fos.close();
        is.close();



        req.setAttribute("filename", filename);
        req.getRequestDispatcher("show.jsp").forward(req, resp);

    }
}
