package ch12.observer;

import ch12.state.State;

public class IoTAppUI implements Observer {
    @Override
    public void update(State state) {
        switch (state.getName()) {
            case "SO COOL" -> System.out.println("[UI] 눈 내리는 효과");
            case "COOL" -> System.out.println("[UI] 바람 부는 효과");
            case "SO HOT" -> System.out.println("[UI] 뜨거운 아지랑이 효과");
            case "HOT" -> System.out.println("[UI] 강렬하게 내리쬐는 태양 효과");
        }

    }
}
