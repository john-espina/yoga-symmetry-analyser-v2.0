import algorithm.SymmetryAnalyser;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/ProcessDataServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*50, // 2MB
        maxFileSize=1024*1024*50,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class ProcessDataServlet extends HttpServlet {
    /**
     * Name of the directory where uploaded file was saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";

    /**
     * retrieves the uploaded file and process the data
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");

        // retrieve the  path of the directory where the file was uploaded
        String savePath = appPath + File.separator + SAVE_DIR;


        //access the newly uploaded file
        String fileToRead = savePath + File.separator + "dataToProcess";
        File file = new File(fileToRead);

        //apply algorithm to test symmetry, returns an object
        HashMap<String, String> dataToProcess = SymmetryAnalyser.analyseSymmetry(file);


        //Forward result to the JSP handler
        request.setAttribute("file", dataToProcess);
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);

    }
}







