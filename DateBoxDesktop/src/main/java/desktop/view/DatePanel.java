package desktop.view;

import core.logic.*;
import desktop.controller.DesktopDateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bjørn on 31.03.2014.
 */
public class DatePanel extends JPanel {

    private static final String
        TITLE_LABEL_TEXT = "Title",
        DESCRIPTION_LABEL_TEXT = "Description",
        COST_LABEL_TEXT = "Cost",
        DURATION_LABEL_TEXT = "Duration",
        LOCATION_LABEL_TEXT = "Location",
        OTHER_LABEL_TEXT = "Other",
        ADD_BUTTON_TEXT = "Add",
        SAVE_BUTTON_TEXT = "Save";

    private static final Dimension
        COMBOBOX_DIMENSION = new Dimension(200, 30),
        TEXTFIELD_DIMENSION = new Dimension(200, 30),
        TEXTAREA_DIMENSION = new Dimension(200, 300),
        LABEL_DIMENSION = new Dimension(100, 30),
        BUTTON_DIMENSION = new Dimension(100, 30);

    private DesktopDateManager parent;
    private Date date;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints gridBagConstraints;

    private JLabel
            titleLabel,
            descriptionLabel,
            costLabel,
            durationLabel,
            locationLabel,
            otherLabel;
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<Cost> costJComboBox;
    private JComboBox<Duration> durationJComboBox;
    private JComboBox<Location> locationJComboBox;
    private JComboBox<Other> otherJComboBox;
    private JButton submitButton;

    public DatePanel(DesktopDateManager manager) {
        parent = manager;
        date = new Date();
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        gridBagConstraints = new GridBagConstraints();

        titleLabel = new JLabel(TITLE_LABEL_TEXT);
        descriptionLabel = new JLabel(DESCRIPTION_LABEL_TEXT);
        costLabel = new JLabel(COST_LABEL_TEXT);
        durationLabel = new JLabel(DURATION_LABEL_TEXT);
        locationLabel = new JLabel(LOCATION_LABEL_TEXT);
        otherLabel = new JLabel(OTHER_LABEL_TEXT);

        titleField = new JTextField();
        descriptionArea = new JTextArea();
        costJComboBox = new JComboBox<Cost>(Cost.values());
        durationJComboBox = new JComboBox<Duration>(Duration.values());
        locationJComboBox = new JComboBox<Location>(Location.values());
        otherJComboBox = new JComboBox<Other>(Other.values());
        submitButton = new JButton(ADD_BUTTON_TEXT);

        titleLabel.setPreferredSize(LABEL_DIMENSION);
        descriptionLabel.setPreferredSize(LABEL_DIMENSION);
        costLabel.setPreferredSize(LABEL_DIMENSION);
        durationLabel.setPreferredSize(LABEL_DIMENSION);
        locationLabel.setPreferredSize(LABEL_DIMENSION);
        otherLabel.setPreferredSize(LABEL_DIMENSION);

        titleField.setPreferredSize(TEXTFIELD_DIMENSION);
        descriptionArea.setPreferredSize(TEXTAREA_DIMENSION);
        costJComboBox.setPreferredSize(COMBOBOX_DIMENSION);
        durationJComboBox.setPreferredSize(COMBOBOX_DIMENSION);
        locationJComboBox.setPreferredSize(COMBOBOX_DIMENSION);
        otherJComboBox.setPreferredSize(COMBOBOX_DIMENSION);
        submitButton.setPreferredSize(BUTTON_DIMENSION);

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(titleField, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        add(descriptionLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(descriptionArea, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        add(costLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(costJComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        add(durationLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(durationJComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        add(locationLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(locationJComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        add(otherLabel, gridBagConstraints);
        gridBagConstraints.gridx++;
        add(otherJComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy++;
        add(submitButton, gridBagConstraints);

        submitButton.addActionListener(new SubmitListener());

    }

    private void updateValues(Date date, boolean emptyDate){
        if(emptyDate){
            titleField.setText(date.getTitle());
            descriptionArea.setText(date.getDescription());
        } else {
            submitButton.setText(SAVE_BUTTON_TEXT);
            titleField.setText(date.getTitle());
            descriptionArea.setText(date.getDescription());
            costJComboBox.setSelectedItem(date.getCost());
            durationJComboBox.setSelectedItem(date.getDuration());
            locationJComboBox.setSelectedItem(date.getLocation());
            otherJComboBox.setSelectedItem(date.getOther());
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date, boolean emptyDate) {
        this.date = date;
        updateValues(date, emptyDate);
    }

    private class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                date.setTitle(titleField.getText());
                date.setDescription(descriptionArea.getText());
                date.setCost((Cost)costJComboBox.getSelectedItem());
                date.setDuration((Duration)durationJComboBox.getSelectedItem());
                date.setLocation((Location)locationJComboBox.getSelectedItem());
                date.setOther((Other) otherJComboBox.getSelectedItem());

                System.out.println("SAVED DATE");
                System.out.println("Title: " + date.getTitle());
                System.out.println("Description: " + date.getDescription());
                System.out.println("Cost: " + date.getCost());
                System.out.println("Duration: " + date.getDuration());
                System.out.println("Location: " + date.getLocation());
                System.out.println("Other: " + date.getOther());

                parent.addDate(date);
            } catch (Exception excepetion){
                excepetion.printStackTrace();
            }
        }
    }
}
