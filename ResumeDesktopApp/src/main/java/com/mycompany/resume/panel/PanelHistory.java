/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.panel;

import com.mycompany.dao.impl.EmploymentHistoryDaoImpl;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.resume.config.Config;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class PanelHistory extends javax.swing.JPanel {

    Config config = Config.creatConfig();
    EmploymentHistoryDaoInter historyDao = new EmploymentHistoryDaoImpl();

    /**
     * Creates new form HistoryPanel
     */
    public PanelHistory() {
        initComponents();
    }

    public void fillWindow() {
        config.getLoggedInUser().setEmploymentHistorys(historyDao.getAllEmploymentHistoryByUserId(config.getLoggedInUser().getId())); //userin ichindeki emphist listine history listi set olunur
        for (EmploymentHistory h : config.getLoggedInUser().getEmploymentHistorys()) { //actually it have to write with table
            config.setUserHistory(h); //historyList`den butun historyler 1-1 chekilir
        }
    }

    public void fillUserComponents() {
        fillWindow();
        txtHeader.setText(config.getUserHistory().getHeader());
        txtBeginDate.setText(config.getUserHistory().getBeginDate().toString());
        txtEndDate.setText(config.getUserHistory().getEndDate().toString());
        txtAreaJobDesc.setText(config.getUserHistory().getJobDescription());

    }

    public void saveBtn() {
        String header = txtHeader.getText();
        String jobDesc = txtAreaJobDesc.getText();
        String beginDateStr = txtBeginDate.getText();
        String endDateStr = txtEndDate.getText();
        Date beginDate = new Date(Date.valueOf(beginDateStr).getTime());
        Date endDate = new Date(Date.valueOf(endDateStr).getTime());

        config.getUserHistory().setHeader(header);
        config.getUserHistory().setBeginDate(beginDate);
        config.getUserHistory().setEndDate(endDate);
        config.getUserHistory().setJobDescription(jobDesc);
        historyDao.update(config.getUserHistory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHistory = new javax.swing.JPanel();
        txtHeader = new javax.swing.JTextField();
        lblHeader = new javax.swing.JLabel();
        txtBeginDate = new javax.swing.JTextField();
        lblBeginDate = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        lblEndDate = new javax.swing.JLabel();
        txtAreaJobDesc = new javax.swing.JTextArea();

        txtHeader.setToolTipText("");

        lblHeader.setText("Header");

        txtBeginDate.setToolTipText("");

        lblBeginDate.setText("Begin Date");

        txtEndDate.setToolTipText("");

        lblEndDate.setText("End Date");

        txtAreaJobDesc.setColumns(20);
        txtAreaJobDesc.setRows(5);

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(lblBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtAreaJobDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeader)
                            .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBeginDate)
                            .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEndDate)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtAreaJobDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBeginDate;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JTextArea txtAreaJobDesc;
    private javax.swing.JTextField txtBeginDate;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtHeader;
    // End of variables declaration//GEN-END:variables
}
