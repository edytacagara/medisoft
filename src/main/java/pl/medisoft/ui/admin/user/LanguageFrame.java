/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.user;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.LanguageEnum;
import pl.medisoft.application.message.Messages;
import pl.medisoft.application.user.param.UserParamBean;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class LanguageFrame extends BaseFrame {

    private static final String IMG_FOLDER = "img/";
    private static final String IMG_EXTENSION = ".gif";

    private final Messages messages = Messages.getInstace();
    private final JFrame parent;
    
    public LanguageFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        initComponents();
        langPanel.setLayout(new GridLayout(LanguageEnum.values().length, 1));
        customize();
        setResizable(false);
    }

    @Override
    public void customize() {
        initLang();
        chooseLangLabel.setText(messages.get("app.lang.chooseLang") + ":");
        ((BaseFrame)parent).customize();
    }

    private void initLang() {
        langPanel.removeAll();
        for (final LanguageEnum lang : LanguageEnum.values()) {
            String displayValue = messages.get("app.lang." + lang.getId());
            String img = IMG_FOLDER + lang.getId() + IMG_EXTENSION;
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(img));
            JButton btn = new JButton(displayValue, icon);
            btn.setHorizontalTextPosition(JButton.LEFT);
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    messages.changeLanguage(lang);
                    saveLang(lang);
                }
            });
            langPanel.add(btn);
            langPanel.validate();
            langPanel.repaint();

            repaint();
        }
    }
    
    private void saveLang(final LanguageEnum lang) {
        if(IdentityProvider.identity != null) {
            UserParamBean userParamBean = new UserParamBean();
            userParamBean.updateUserLanguage(IdentityProvider.identity.getId(), lang.getId());
        }
        customize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseLangLabel = new javax.swing.JLabel();
        langPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        chooseLangLabel.setText("Wybierz język:");

        javax.swing.GroupLayout langPanelLayout = new javax.swing.GroupLayout(langPanel);
        langPanel.setLayout(langPanelLayout);
        langPanelLayout.setHorizontalGroup(
            langPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        langPanelLayout.setVerticalGroup(
            langPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseLangLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(langPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseLangLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(langPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseLangLabel;
    private javax.swing.JPanel langPanel;
    // End of variables declaration//GEN-END:variables
}
