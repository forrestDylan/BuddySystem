package edu.rit.dxf7606.buddysystem;

/**
 * Created by Dylan Forrest on 10/9/2016.
 */
public class SystemSettings {
    private SystemSettings(){}
    protected Phone phone = BuddyManager.BuddyManager().phone ;
    protected double chosenRadius = 5;

    private void initBuddies() {
        for (int i = 0; i < phone.chosenContacts.size(); i++ ) {
            Contact contact = new Contact( phone.chosenContacts.get(i).name, phone.chosenContacts.get(i).phoneNumber ) ;
            BuddyManager.BuddyManager().addBuddy(contact.name, contact.phoneNumber);
        }
    }

    private static class SystemSettingsAux {
        private static final SystemSettings settingsManager = new SystemSettings();
    }

    public static SystemSettings SystemSettings() {
        return SystemSettingsAux.settingsManager ;
    }

}
