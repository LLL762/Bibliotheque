package com.afpa.bibliotheque.model;

import java.beans.PropertyChangeListener;

public interface AppObservable {

    void addPropertyChangeListener(PropertyChangeListener pcl);

    void removePropertyChangeListener(PropertyChangeListener pcl);

    PropertyChangeListener[] getObserver();


}
