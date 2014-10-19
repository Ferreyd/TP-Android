package database;

/**
 * Created by cordi_000 on 18/10/2014.
 */
public class User {

    private int _id;
    private String _nom;
    private String __prenom;
    private String _sexe;
    private String _phone;
    private String _mail;
    private String _pass;

    /**
     *
     * @param _id
     * @param _nom
     * @param __prenom
     * @param _sexe
     * @param _phone
     * @param _mail
     * @param _pass
     */
    public User(int _id, String _nom, String __prenom, String _sexe, String _phone, String _mail, String _pass) {
        this._id = _id;
        this._nom = _nom;
        this.__prenom = __prenom;
        this._sexe = _sexe;
        this._phone = _phone;
        this._mail = _mail;
        this._pass = _pass;
    }

    /**
     *
     * @param _nom
     * @param __prenom
     * @param _sexe
     * @param _phone
     * @param _mail
     * @param _pass
     */
    public User(String _nom, String __prenom, String _sexe, String _phone, String _mail, String _pass) {
        this._id = _id;
        this._nom = _nom;
        this.__prenom = __prenom;
        this._sexe = _sexe;
        this._phone = _phone;
        this._mail = _mail;
        this._pass = _pass;
    }
    public User()
    {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nom() {
        return _nom;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }

    public String get__prenom() {
        return __prenom;
    }

    public void set__prenom(String __prenom) {
        this.__prenom = __prenom;
    }

    public String get_sexe() {
        return _sexe;
    }

    public void set_sexe(String _sexe) {
        this._sexe = _sexe;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_mail() {
        return _mail;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }
}

