/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przych_med;

import DAO.CHO_WIZ_DAO;
import DAO.Lekarze_DAO;
import DAO.Pacjenci_DAO;
import DAO.Wizyty_DAO;
import Models.Cho_Wiz;
import Models.Choroby;

import Models.Lekarze;
import Models.Pacjenci;
import Models.Wizyty;

import java.net.URL;

import java.sql.Date;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lukasz
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Lekarze> tableviewlekarze;
    @FXML
    private TableColumn lekarze_imie;
    @FXML
    private TableColumn lekarze_nazwisko;
    @FXML
    private TableColumn lekarze_pesel;
    @FXML
    private TableColumn lekarze_nr_tel;
    @FXML
    private TableColumn lekarze_nr_gabinetu;
    @FXML
    private TableColumn lekarze_data_zat;
    @FXML
    private TableColumn lekarze_wynagrodzenie;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie_pac = new TableColumn<>("pacjenci");
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko_pac = new TableColumn<>("pacjenci");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie_lek = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko_lek = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_objawy;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data_nast;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data;
    @FXML
    private TableView<Wizyty> tableviewwizyty;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie_pac1 = new TableColumn<>("pacjenci");
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko_pac1 = new TableColumn<>("pacjenci");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie_lek1 = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko_lek1 = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_objawy1;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data_nast1;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data1;
    @FXML
    private TableView<Wizyty> tableviewwizyty1;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie_pac_przyszle = new TableColumn<>("pacjenci");
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko_pac_przyszle = new TableColumn<>("pacjenci");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_imie__przyszle = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_nazwisko__przyszle = new TableColumn<>("lekarze");
    ;
    @FXML
    private TableColumn<Wizyty, String> wiz_objawy_przyszle;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data_nast_przyszle;
    @FXML
    private TableColumn<Wizyty, Date> wiz_data_przyszle;
    @FXML
    private TableView<Wizyty> tableviewwizyty_przyszle;

    @FXML
    private TextField tf_lekarz_imie;
    @FXML
    private TextField tf_lekarz_nazwisko;
    @FXML
    private TextField tf_lekarz_pesel;
    @FXML
    private TextField tf_lekarz_nr_tel;
    @FXML
    private TextField tf_lekarz_nr_gabinetu;
    @FXML
    private TextField tf_lekarz_wyplata;
    @FXML
    private TextField tf_lekarz_datazat;

    @FXML
    private Button add_lekarz;
    @FXML
    private Button del_lekarz;

    private final Lekarze_DAO le_DAO = new Lekarze_DAO();
    private final Pacjenci_DAO pac_DAO = new Pacjenci_DAO();
    public  int kwerenda;
    private final Wizyty_DAO wiz_prze = new Wizyty_DAO();
    private final Wizyty_DAO wiz_obec = new Wizyty_DAO();
    private final Wizyty_DAO wiz_przyszle = new Wizyty_DAO();
    private final CHO_WIZ_DAO cho_wiz = new CHO_WIZ_DAO();
    @FXML
    private TextField add_wiz_data;
    @FXML
    private TextField add_wiz_objawy;
    @FXML
    private Button add_wiz;
    @FXML
    private ChoiceBox<Lekarze> add_wiz_lek;
    @FXML
    private ChoiceBox<Pacjenci> add_wiz_pac;
    @FXML
    private ChoiceBox<Wizyty> choicebox_wiz;
    @FXML
    private ListView<Cho_Wiz> view_wiz_det;
    @FXML
    private Button view_all_detals;

    public void show_chowiz() throws SQLException, ParseException {
        
        kwerenda = choicebox_wiz.getSelectionModel().getSelectedItem().getId_wizyty();

        System.out.println(kwerenda);

        view_wiz_det.setItems(FXCollections.observableArrayList(cho_wiz.getchoroby(kwerenda)));

    }

    public void add_wiz() throws SQLException, ParseException {
        Wizyty wizyta = new Wizyty();
        Lekarze lekarz = new Lekarze();
        Pacjenci pacjent = new Pacjenci();
        wizyta.setObjawy(add_wiz_objawy.getText());
        lekarz = add_wiz_lek.getSelectionModel().getSelectedItem();
        pacjent = add_wiz_pac.getSelectionModel().getSelectedItem();
        wizyta.setPacjenci(pacjent);
        wizyta.setLekarze(lekarz);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date invoiceDate = formatDate.parse(add_wiz_data.getText());
        java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate.getTime());
        wizyta.setData_wizyty(sqlDate2);

        Wizyty_DAO.create(wizyta);
        System.out.println(wizyta);
    }

    public void add_lekarz() throws SQLException, ParseException {

        Lekarze lekarz = new Lekarze();
        lekarz.setImie(tf_lekarz_imie.getText());
        lekarz.setNazwisko(tf_lekarz_nazwisko.getText());
        lekarz.setNr_gabinetu(Integer.parseInt(tf_lekarz_nr_gabinetu.getText()));
        lekarz.setPesel(tf_lekarz_pesel.getText());
        lekarz.setNr_tel(tf_lekarz_nr_tel.getText());
        lekarz.setWynagrodzenie(Integer.parseInt(tf_lekarz_wyplata.getText()));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date invoiceDate = formatDate.parse(tf_lekarz_datazat.getText());
        java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
        lekarz.setData_zat(sqlDate);

        Lekarze_DAO.create(lekarz);
        System.out.println(lekarz);

    }

    public void del_lekarz() throws SQLException, ParseException {

        Lekarze lekarz = new Lekarze();
        lekarz = tableviewlekarze.getSelectionModel().getSelectedItem();

        lekarz.getId_lekarza();
        Lekarze_DAO.delete(lekarz);

    }

    public void table_view_wizty() throws SQLException, ParseException {
        wiz_data.setCellValueFactory(new PropertyValueFactory<>("data_wizyty"));
        wiz_imie_pac.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getImie()));
        wiz_nazwisko_pac.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getNazwisko()));
        wiz_imie_lek.setCellValueFactory(lek -> new SimpleStringProperty(lek.getValue().getLekarze().getImie()));
        wiz_nazwisko_lek.setCellValueFactory(lek -> new SimpleStringProperty(lek.getValue().getLekarze().getNazwisko()));
        wiz_objawy.setCellValueFactory(new PropertyValueFactory<>("objawy"));
        wiz_data_nast.setCellValueFactory(new PropertyValueFactory<>("nast_wizyta"));

        tableviewwizyty.setItems(FXCollections.observableArrayList(wiz_prze.getAll()));

    }

    public void table_view_wizty1() throws SQLException, ParseException {
        wiz_data1.setCellValueFactory(new PropertyValueFactory<>("data_wizyty"));
        wiz_imie_pac1.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getImie()));
        wiz_nazwisko_pac1.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getNazwisko()));
        wiz_imie_lek1.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getImie()));
        wiz_nazwisko_lek1.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getNazwisko()));
        wiz_objawy1.setCellValueFactory(new PropertyValueFactory<>("objawy"));
        wiz_data_nast1.setCellValueFactory(new PropertyValueFactory<>("nast_wizyta"));

        tableviewwizyty1.setItems(FXCollections.observableArrayList(wiz_obec.get_obec()));

    }

    public void table_view_wiztyprzyszle() throws SQLException, ParseException {
        wiz_data_przyszle.setCellValueFactory(new PropertyValueFactory<>("data_wizyty"));
        wiz_imie_pac_przyszle.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getImie()));
        wiz_nazwisko_pac_przyszle.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getPacjenci().getNazwisko()));
        wiz_imie__przyszle.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getImie()));
        wiz_nazwisko__przyszle.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getNazwisko()));
        wiz_objawy_przyszle.setCellValueFactory(new PropertyValueFactory<>("objawy"));
        wiz_data_nast_przyszle.setCellValueFactory(new PropertyValueFactory<>("nast_wizyta"));

        tableviewwizyty_przyszle.setItems(FXCollections.observableArrayList(wiz_przyszle.get_przyszle()));

    }

    public void table_view_lekarz() throws SQLException, ParseException {
        lekarze_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        lekarze_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        lekarze_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        lekarze_nr_tel.setCellValueFactory(new PropertyValueFactory<>("nr_tel"));
        lekarze_nr_gabinetu.setCellValueFactory(new PropertyValueFactory<>("nr_gabinetu"));
        lekarze_data_zat.setCellValueFactory(new PropertyValueFactory<>("data_zat"));
        lekarze_wynagrodzenie.setCellValueFactory(new PropertyValueFactory<>("wynagrodzenie"));
        tableviewlekarze.setItems(FXCollections.observableArrayList(le_DAO.getAll()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // try {
        // view_wiz_det.setItems(FXCollections.observableArrayList(cho_wiz.get_choroby()));
        //} catch (SQLException ex) {
        //    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        // } catch (ParseException ex) {
        //     Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        // }
        try {
            choicebox_wiz.setItems(FXCollections.observableArrayList(wiz_prze.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            add_wiz_lek.setItems(FXCollections.observableArrayList(le_DAO.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            add_wiz_pac.setItems(FXCollections.observableArrayList(pac_DAO.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        del_lekarz.setOnAction((ActionEvent event) -> {
            try {
                del_lekarz();
                table_view_lekarz();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        add_wiz.setOnAction((ActionEvent event) -> {

            try {
                add_wiz();
                table_view_wizty();
                table_view_wizty1();
                table_view_wiztyprzyszle();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        view_all_detals.setOnAction((ActionEvent event) -> {
            try {
                show_chowiz();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        add_lekarz.setOnAction((ActionEvent event) -> {

            try {
                add_lekarz();
                table_view_lekarz();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        try {
            table_view_wiztyprzyszle();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            table_view_wizty1();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            table_view_wizty();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            table_view_lekarz();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
