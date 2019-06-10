/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przych_med;

import DAO.CHO_WIZ_DAO;
import DAO.Choroby_DAO;
import DAO.Lek_Spec_DAO;
import DAO.Lek_Wiz_DAO;
import DAO.Lekarze_DAO;
import DAO.Leki_DAO;
import DAO.Pacjenci_DAO;
import DAO.Specjalizacje_DAO;
import DAO.Urlopy_DAO;
import DAO.Wizyty_DAO;
import Models.Cho_Wiz;
import Models.Choroby;
import Models.Lek_Spec;
import Models.Lek_Wiz;
import Models.Lekarze;
import Models.Leki;
import Models.Pacjenci;
import Models.Specjalizacje;
import Models.Urlopy;
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
    public int kwerenda;
    private final Wizyty_DAO wiz_prze = new Wizyty_DAO();
    private final Wizyty_DAO wiz_obec = new Wizyty_DAO();
    private final Wizyty_DAO wiz_przyszle = new Wizyty_DAO();
    private final CHO_WIZ_DAO cho_wiz = new CHO_WIZ_DAO();
    private final Lek_Wiz_DAO lek_wiz = new Lek_Wiz_DAO();
    private final Specjalizacje_DAO spec = new Specjalizacje_DAO();
    private final Lek_Spec_DAO lek_spec = new Lek_Spec_DAO();
    private final Pacjenci_DAO pac = new Pacjenci_DAO();
    private final Urlopy_DAO urlopy = new Urlopy_DAO();
    private final Choroby_DAO choroby=new Choroby_DAO();
    private final Leki_DAO leki=new Leki_DAO();
    @FXML
    private TextField add_wiz_data;
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
    @FXML
    private ListView<Lek_Wiz> view_wiz_lek_det;
    @FXML
    private ChoiceBox<Specjalizacje> select_spec;
    @FXML
    private ListView<Lek_Spec> list_lek_spec;
    public int kwerenda2;
    @FXML
    private Button show_lek_spec;
    @FXML
    private TableView<Pacjenci> tableviewpacenci;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_imie;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_nazwisko;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_nr_tel;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_pesel;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_ulica;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_kod;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_miasto;
    @FXML
    private TableColumn<Pacjenci, String> pacjent_ubezpieczenie;
    @FXML
    private TextField add_pac_im;
    @FXML
    private TextField add_pac_nazw;
    @FXML
    private TextField add_pac_nr;
    @FXML
    private TextField add_pac_pesel;
    @FXML
    private TextField add_pac_ul;
    @FXML
    private TextField ad_pac_kod;
    @FXML
    private TextField add_pac_miasto;
    @FXML
    private TextField add_refundacja;
    @FXML
    private Button add_pac;
    @FXML
    private Button del_pac;
    @FXML
    private TableView<Urlopy> tableviewurlopy;
    @FXML
    private TableColumn<Urlopy, String> urlop_imie = new TableColumn<>("lekarze");
    @FXML
    private TableColumn<Urlopy, String> urlop_nazwisko = new TableColumn<>("lekarze");
    @FXML
    private TableColumn<Urlopy, Date> urlop_pocz;
    @FXML
    private Button dodajurlop;
    @FXML
    private ChoiceBox<Lekarze> urlopylek;
    @FXML
    private TextField add_data_poc;
    @FXML
    private TextField add_data_kon;
    @FXML
    private TableColumn<Urlopy, Date> urlop_konc;
    @FXML
    private Button edit_lek;
    @FXML
    private Button update_lek;
    public int idlekarza;
    public int id_wizytyobec;
    @FXML
    private Button edit_wiz;
    @FXML
    private Button update_wiz;
    @FXML
    private Button del_wiz;
    
    public Wizyty wizyta_edit;
    @FXML
    private TextField edit_objawy_wizyta;
    @FXML
    private TextField edit_wiz_obec_data;
    @FXML
    private Button edit_pac;
    @FXML
    private Button update_pacjenci;
    public int id_pacjenta;
    @FXML
    private ChoiceBox<Choroby> choice_box_choroby;
    
    @FXML
    private ChoiceBox<Leki> choice_box_leki;
    @FXML
    private Button add_lek_chor;
    int id_wiz;
    int id_cho;
    int id_lek;
    public void addwiz_cho()throws SQLException, ParseException{
        Choroby choroba=new Choroby();
        Cho_Wiz chowiz=new Cho_Wiz();
                
        choroba=choice_box_choroby.getSelectionModel().getSelectedItem();
        id_cho=choroba.getId_choroby();
        choroba.setId_choroby(id_wiz);
        chowiz.setChoroba(choroba);
       
        
        
    
    }
    public void add_wiz_lek()throws SQLException, ParseException{
        Wizyty wizyta= new Wizyty();
        wizyta=choicebox_wiz.getSelectionModel().getSelectedItem();
        id_wiz=wizyta.getId_wizyty();
        wizyta.setId_wizyty(id_wiz);
       
        
        
    
    }
    
    
    public void update_pacjenci()throws SQLException, ParseException{
    Pacjenci pacjent= new Pacjenci();
        
        pacjent.setImie(add_pac_im.getText());
        pacjent.setNazwisko(add_pac_nazw.getText());
        pacjent.setNr_tel(add_pac_nr.getText());
        pacjent.setPesel(add_pac_pesel.getText());
        pacjent.setUlica(add_pac_ul.getText());
        pacjent.setKod_pocztowy(ad_pac_kod.getText());
        pacjent.setMiasto(add_pac_miasto.getText());
        pacjent.setUbezpieczenie(add_refundacja.getText());
        pacjent.setId_pacjenta(id_pacjenta);
        Pacjenci_DAO.update(pacjent);
        
    
    }
    public void edit_pac()throws SQLException, ParseException{
        Pacjenci pacjent= new Pacjenci();
        pacjent= tableviewpacenci.getSelectionModel().getSelectedItem();
        id_pacjenta= pacjent.getId_pacjenta();
        add_pac_im.setText(pacjent.getImie());
        add_pac_nazw.setText(pacjent.getNazwisko());
        add_pac_nr.setText(pacjent.getNr_tel());
        add_pac_pesel.setText(pacjent.getPesel());
        add_pac_ul.setText(pacjent.getUlica());
        ad_pac_kod.setText(pacjent.getKod_pocztowy());
        add_pac_miasto.setText(pacjent.getMiasto());
        add_refundacja.setText(pacjent.getUbezpieczenie());
        
        
       
    }
    
    public void del_wiz()throws SQLException, ParseException{
    
    Wizyty wizyta= new Wizyty();
    wizyta=tableviewwizyty_przyszle.getSelectionModel().getSelectedItem();
    wizyta.getId_wizyty();
    Wizyty_DAO.delete(wizyta);
            
    }
    
    public void update_wiz_obc()throws SQLException, ParseException{
        Wizyty wizyta = new Wizyty();
        wizyta.setObjawy(edit_objawy_wizyta.getText());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date invoiceDate = formatDate.parse(edit_wiz_obec_data.getText());
        java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
        wizyta.setNast_wizyta(sqlDate);
      
        wizyta.setId_wizyty(id_wizytyobec);
       
        Wizyty_DAO.update(wizyta);
      
    }
    public void edit_wiz() throws SQLException, ParseException{
        Wizyty wizyta= new Wizyty();
        wizyta= tableviewwizyty1.getSelectionModel().getSelectedItem();
        id_wizytyobec= wizyta.getId_wizyty();
        
        
    }
    
    public void update_lek() throws SQLException, ParseException{
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
        lekarz.setId_lekarza(idlekarza);
        Lekarze_DAO.update(lekarz);
       
        
        
    }
            
    public void edit_lek() throws SQLException, ParseException{
        Lekarze lekarz= new Lekarze();
        lekarz= tableviewlekarze.getSelectionModel().getSelectedItem();
        idlekarza= lekarz.getId_lekarza();
        tf_lekarz_imie.setText(lekarz.getImie());
        tf_lekarz_nazwisko.setText(lekarz.getNazwisko());
        tf_lekarz_nr_gabinetu.setText(Integer.toString(lekarz.getNr_gabinetu()));
        tf_lekarz_nr_tel.setText(lekarz.getNr_tel());
        tf_lekarz_pesel.setText(lekarz.getPesel());
        tf_lekarz_wyplata.setText(Integer.toString(lekarz.getWynagrodzenie()));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        String zmienna=formatDate.format(lekarz.getData_zat());
        tf_lekarz_datazat.setText(zmienna);
        
    
    }
    
    public void dodajurlop() throws SQLException, ParseException {
        Urlopy urlop = new Urlopy();
        Lekarze lekarz = new Lekarze();
        lekarz = urlopylek.getSelectionModel().getSelectedItem();
        urlop.setLekarze(lekarz);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date invoiceDate = formatDate.parse(add_data_poc.getText());
        java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate.getTime());
        urlop.setData_pocz(sqlDate2);
        java.util.Date invoiceDate2 = formatDate.parse(add_data_kon.getText());
        java.sql.Date sqlDate = new java.sql.Date(invoiceDate2.getTime());
        urlop.setData_konc(sqlDate);

        Urlopy_DAO.create(urlop);
        tableviewurlopy();
    }

    public void tableviewurlopy() throws SQLException, ParseException {

        urlop_imie.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getImie()));
        urlop_nazwisko.setCellValueFactory(pac -> new SimpleStringProperty(pac.getValue().getLekarze().getNazwisko()));
        urlop_pocz.setCellValueFactory(new PropertyValueFactory<>("data_pocz"));
        urlop_konc.setCellValueFactory(new PropertyValueFactory<>("data_konc"));

        tableviewurlopy.setItems(FXCollections.observableArrayList(urlopy.getAll()));

    }

    public void del_pacjent() throws SQLException, ParseException {
        Pacjenci pacjent = new Pacjenci();
        pacjent = tableviewpacenci.getSelectionModel().getSelectedItem();

        pacjent.getId_pacjenta();
        Pacjenci_DAO.delete(pacjent);

    }

    public void add_pacjent() throws SQLException, ParseException {

        Pacjenci pacjent = new Pacjenci();
        pacjent.setImie(add_pac_im.getText());
        pacjent.setNazwisko(add_pac_nazw.getText());
        pacjent.setNr_tel(add_pac_nr.getText());
        pacjent.setPesel(add_pac_pesel.getText());
        pacjent.setUlica(add_pac_ul.getText());
        pacjent.setKod_pocztowy(ad_pac_kod.getText());
        pacjent.setMiasto(add_pac_miasto.getText());
        pacjent.setUbezpieczenie(add_refundacja.getText());

        Pacjenci_DAO.create(pacjent);
        System.out.println(pacjent);

    }

    public void table_view_pacjenci() throws SQLException, ParseException {

        pacjent_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        pacjent_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        pacjent_nr_tel.setCellValueFactory(new PropertyValueFactory<>("nr_tel"));
        pacjent_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        pacjent_ulica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        pacjent_kod.setCellValueFactory(new PropertyValueFactory<>("kod_pocztowy"));
        pacjent_miasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        pacjent_ubezpieczenie.setCellValueFactory(new PropertyValueFactory<>("ubezpieczenie"));
        tableviewpacenci.setItems(FXCollections.observableArrayList(pac.getAll()));

    }

    public void show_lek_spec() throws SQLException, ParseException {

        kwerenda2 = select_spec.getSelectionModel().getSelectedItem().getId_specjalizacji();
        list_lek_spec.setItems(FXCollections.observableArrayList(lek_spec.getspec_lek(kwerenda2)));

    }

    public void show_chowiz() throws SQLException, ParseException {

        kwerenda = choicebox_wiz.getSelectionModel().getSelectedItem().getId_wizyty();
        view_wiz_det.setItems(FXCollections.observableArrayList(cho_wiz.getchoroby(kwerenda)));
        view_wiz_lek_det.setItems(FXCollections.observableArrayList(lek_wiz.getLeki(kwerenda)));
    }

    public void add_wiz() throws SQLException, ParseException {
        Wizyty wizyta = new Wizyty();
        Lekarze lekarz = new Lekarze();
        Pacjenci pacjent = new Pacjenci();
        
        lekarz = add_wiz_lek.getSelectionModel().getSelectedItem();
        pacjent = add_wiz_pac.getSelectionModel().getSelectedItem();
        wizyta.setPacjenci(pacjent);
        wizyta.setLekarze(lekarz);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date invoiceDate = formatDate.parse(add_wiz_data.getText());
        java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate.getTime());
        wizyta.setData_wizyty(sqlDate2);
        System.out.println(pacjent);
        Wizyty_DAO.create(wizyta);

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
        try {
            choice_box_leki.setItems(FXCollections.observableArrayList(leki.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            choice_box_choroby.setItems(FXCollections.observableArrayList(choroby.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        update_pacjenci.setOnAction((ActionEvent event)->{
            try {
                update_pacjenci();
                table_view_pacjenci();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
        edit_pac.setOnAction((ActionEvent event)->{
            try {
                edit_pac();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        del_wiz.setOnAction((ActionEvent event)->{
            try {
                del_wiz();
                table_view_wiztyprzyszle();
                
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        update_wiz.setOnAction((ActionEvent event)->{
            try {
                update_wiz_obc();
              table_view_wizty1() ;
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        edit_wiz.setOnAction((ActionEvent event)->{
            try {
                edit_wiz();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        });
        
        update_lek.setOnAction((ActionEvent event)->{
            try {
                update_lek();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        edit_lek.setOnAction((ActionEvent event) -> {
            try {
                edit_lek();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        dodajurlop.setOnAction((ActionEvent event) -> {
            try {
                dodajurlop();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        try {
            tableviewurlopy();
            urlopylek.setItems(FXCollections.observableArrayList(le_DAO.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        del_pac.setOnAction((ActionEvent event) -> {

            try {
                del_pacjent();
                table_view_pacjenci();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        add_pac.setOnAction((ActionEvent event) -> {
            try {
                add_pacjent();
                table_view_pacjenci();

            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        try {
            table_view_pacjenci();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        show_lek_spec.setOnAction((ActionEvent event) -> {
            try {
                show_lek_spec();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        try {
            select_spec.setItems(FXCollections.observableArrayList(spec.getAll()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
