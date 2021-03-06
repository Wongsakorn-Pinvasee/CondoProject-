package ku.cs.condo.controllers.fullInformationController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.condo.models.storage.Item;
import ku.cs.condo.services.etcService.ImageService;


public class FullLetterController {

    private Item item;
    private ImageService imageService;
    private String theme;

    @FXML private ImageView imageView;
    @FXML private Label receiverLabel, buildingLabel
            , roomNumLabel, sizeLabel, senderLabel, statusLabel, officerGetLabel, dateTimeLabel
            , officerOutLabel, residentOutLabel, dateTimeOutLabel
            , officerOutTopic, residentOutTopic, dateTimeOutTopic;

    @FXML public void initialize() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showTheme();

                imageService = new ImageService();

                receiverLabel.setText(item.getReceiver());
                buildingLabel.setText(item.getBuilding());
                roomNumLabel.setText(item.getRoomNum());
                sizeLabel.setText(item.getSize());
                senderLabel.setText(item.getSender());
                statusLabel.setText(item.getStatus());
                officerGetLabel.setText(item.getOfficerGet());
                dateTimeLabel.setText(item.getDateTime());
                if(item.getType().equals("still")){
                    officerOutLabel.setVisible(false);
                    residentOutLabel.setVisible(false);
                    dateTimeOutLabel.setVisible(false);
                    officerOutTopic.setVisible(false);
                    residentOutTopic.setVisible(false);
                    dateTimeOutTopic.setVisible(false);
                }
                else{
                    officerOutLabel.setText(item.getOfficerOut());
                    residentOutLabel.setText(item.getResidentOut());
                    dateTimeOutLabel.setText(item.getDateTimeOut());
                }
                try {
                    imageView.setImage(new Image(imageService.getImage("itemPicture", item.getImagePath())));
                }catch (NullPointerException ignored){}
            }

        });

    }

    private void showTheme(){
        Scene thisScene = buildingLabel.getScene();
        if(theme.equals("abstract")){
            thisScene.getStylesheets().add("/StyleSheet/abstract.css");
        }
        else if(theme.equals("classic")){
            thisScene.getStylesheets().add("/StyleSheet/classic.css");
        }
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
