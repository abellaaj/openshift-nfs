package omar.mebarki.openshifthelloworld;

import omar.mebarki.model.FileModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Value("${app.dir}")
    private String nfsDir;

    @RequestMapping("/")
    public String hello(Model model) {
        List<FileModel> files = new ArrayList<>();
        try {
            Files.list(Paths.get(nfsDir))
                    .forEach(f -> files.add(new FileModel(Files.isDirectory(f), f.getFileName().toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("files", files);
        return "index";
    }
}
