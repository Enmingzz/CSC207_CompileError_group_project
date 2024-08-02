package app.map_usecase_factory;

import app.mainpage_usecase_factory.MainPageUseCaseFactory;
import view.map.MapView;

public class MapUseCaseFactory {
    public static MapView create(){
        return new MapView();
    }
}
