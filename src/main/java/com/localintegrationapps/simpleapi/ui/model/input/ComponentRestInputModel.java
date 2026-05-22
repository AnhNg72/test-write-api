package com.localintegrationapps.simpleapi.ui.model.input;

import java.util.List;

public class ComponentRestInputModel {

    private ComponentKopfRestInputModel kopf;
    private List<ComponentPositionRestInputModel> position;

    public ComponentKopfRestInputModel getKopf() {
        return kopf;
    }

    public void setKopf(ComponentKopfRestInputModel kopf) {
        this.kopf = kopf;
    }

    public List<ComponentPositionRestInputModel> getPosition() {
        return position;
    }

    public void setPosition(List<ComponentPositionRestInputModel> position) {
        this.position = position;
    }
}
