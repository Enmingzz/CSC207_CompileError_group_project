package interface_adapter.main_page;

public class MainPageViewModel {

    private final MainPageState state = new MainPageState();

    public MainPageState getState() {
        return state;
    }
}
