package MusicFind.src;

public class User {
    public int id;
    public String contato;
    public float rating;
    public String username;
    public String userpassword;
    public String tipo;
    public String genero;
    public String instrumento;
    public int anos_experiencia;
    public float cache;

    // Construtor vazio
    public User() {
        this.id = 0;
        this.contato = "";
        this.rating = 0;
        this.username = "";
        this.userpassword = "";
        this.tipo = "";
        this.genero = "";
        this.instrumento = "";
        this.anos_experiencia = 0;
        this.cache = 0;
    }

    // Construtor para usuário comum
    public User(int id, String contato, float rating, String username, String userpassword, String tipo) {
        this.id = id;
        this.contato = contato;
        this.rating = rating;
        this.username = username;
        this.userpassword = userpassword;
        this.tipo = tipo;
    }

    // Construtor para usuário músico
    public User(int id, String contato, float rating, String username, String userpassword, String tipo, String genero, String instrumento, int anos_experiencia, float cache) {
        this.id = id;
        this.contato = contato;
        this.rating = rating;
        this.username = username;
        this.userpassword = userpassword;
        this.tipo = tipo;
        this.genero = genero;
        this.instrumento = instrumento;
        this.anos_experiencia = anos_experiencia;
        this.cache = cache;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public int getAnos_experiencia() {
        return anos_experiencia;
    }

    public void setAnos_experiencia(int anos_experiencia) {
        this.anos_experiencia = anos_experiencia;
    }

    public float getCache() {
        return cache;
    }

    public void setCache(float cache) {
        this.cache = cache;
    }

    public void printUser() {
        System.out.println("ID: " + this.id);
        System.out.println("Contato: " + this.contato);
        System.out.println("Rating: " + this.rating);
        System.out.println("Username: " + this.username);
        System.out.println("Userpassword: " + this.userpassword);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Genero: " + this.genero);
        System.out.println("Instrumento: " + this.instrumento);
        System.out.println("Anos de experiência: " + this.anos_experiencia);
        System.out.println("Cache: " + this.cache);
    }

}
