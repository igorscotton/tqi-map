import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares);
        carrosPopulares.put("gol", 15.2);

        System.out.println(carrosPopulares);

        System.out.println("possui modelo tucson? " + carrosPopulares.containsKey("tucson"));

        System.out.println("exiba o consumo do uno " + carrosPopulares.get("uno"));
    
        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());
        Set<String> modelos = carrosPopulares.keySet();

        System.out.println("exiba os consumos dos carros: " + carrosPopulares.values());
        Collection<Double> consumos = carrosPopulares.values();

        Double consumoMax = Collections.max(carrosPopulares.values());

        System.out.println("maior consumo: " + consumoMax);
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        String modeloComMaisConsumo = "";

        for(Map.Entry<String, Double> entry : entries){
            if(entry.getValue().equals(consumoMax)){
                modeloComMaisConsumo = entry.getKey();
            }
        }

        System.out.println("Modelo com mais consumo: " + modeloComMaisConsumo + " - " + consumoMax);
        

        System.out.println("modelo com menor consumo: ");

        Double consumoMin = Collections.min(carrosPopulares.values());
        String modeloComMenosConsumo = "";
        for(Map.Entry<String, Double> entry : carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMin)){
                modeloComMenosConsumo = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloComMenosConsumo + " - " + consumoMin);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }

        System.out.println(soma);

        System.out.println("Exiba a média: " + soma/carrosPopulares.size());

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator.next().equals(15.6)){
                iterator.remove();
            }
        }

        System.out.println(carrosPopulares);


        System.out.println("Exiba todos os modelos na ordem que foram informados: ");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares1);

        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);

        System.out.println(carrosPopulares2);

        carrosPopulares.clear();

        System.out.println(carrosPopulares.isEmpty());


        /* ORDENAÇÃO DE MAP */

        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições Para o Século 21", 432));
        }};
        
        
    }
}


class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas){
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome(){
        return nome;
    }

    public Integer getPaginas(){
        return paginas;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString(){
        return "{" + "nome = " + nome + 
               ", paginas = " + paginas + "}";    
    }
}
