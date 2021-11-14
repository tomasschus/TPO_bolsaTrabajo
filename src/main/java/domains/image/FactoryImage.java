package domains.image;

import domains.OfertaLaboral;
import enums.ImageFormatEnum;

public class FactoryImage {


    public static ExportStrategy generarImagen(OfertaLaboral ofertaLaboral, ImageFormatEnum imageFormatEnum) {
        ExportStrategy image = null;

        switch (imageFormatEnum){
            case JPG: image = new Jpg();
            break;
            case PNG: image = new Png();
            break;
            case SVG: image = new Svg();
            break;
        }
        return image;
    }
}
