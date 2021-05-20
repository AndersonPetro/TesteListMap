package profissoes;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class ProfissoesTeste {


    public static void main(String[] args) {
        List<Person> people = getPeople();

       // List<String> name = new ArrayList<>();
        // name.add("");


        new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00));
        new Professional(1, "GERENTE", BigDecimal.valueOf(2900.00));
        new Professional(1, "ANALISTA", BigDecimal.valueOf(3800.00));
        //getPeople().stream()

        System.out.println("----------LISTA DE NOMES MASCULINOS:----------------- ");

        List<String> nameMale = people.stream()
                .filter(person -> person.getSex().equals(SexEnum.MALE))
                .map(person -> person.getName())
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        nameMale.forEach(System.out::println);

        System.out.println("---------LISTA DE NOMES FEMININOS------------------");
        List<String> namefemale = people.stream()
                .filter(person -> person.getSex().equals(SexEnum.FEMALE))
                .map(person -> person.getName())
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        namefemale.forEach(System.out::println);

        List<BigDecimal> salary = people.stream()
                .map(person -> person.getProfessional().getSalary())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("SALARIO ");
        salary.forEach(System.out::println);

        List<String> ordemAlfabetica = people.stream()
                .map(person -> person.getName())
                .limit(3)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("ordem alfabetica");
        ordemAlfabetica.forEach(System.out::println);

        List<BigDecimal>ordemSalary = people.stream()
                .map(person -> person.getProfessional().getSalary())
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Ordem salario");
        ordemSalary.forEach(System.out::println);

        //ESTA CERTO TAMBEM
   //     BigDecimal highestSalary = people.stream()
     //           .filter(person -> person.getProfessional().getName().equals("DESENVOLVEDOR"))
       //         .map(person -> person.getProfessional().getSalary())
         //       .max(BigDecimal::compareTo)
           //     .get();


        //System.out.println("Teste salario maior Desenvolvedor " + highestSalary);

        //trazer salarios  de cada profissao pedida
        people.stream()
                .filter(person -> person.getProfessional().getName().equals("DESENVOLVEDOR"))
                .map(person -> person.getProfessional().getSalary())
                .max(BigDecimal::compareTo)
                .stream().forEach(val -> System.out.println("Maior Salario do Desenvolvedor: " + val));

        people.stream()
                .filter(person -> person.getProfessional().getName().equals("GERENTE"))
                .map(person -> person.getProfessional().getSalary())
                .max((x1,x2) -> x1 .compareTo(x2))
                .stream().forEach(val -> System.out.println("Maior Salario de Gerente: " + val));

        people.stream()
                .filter(person -> person.getProfessional().getName().equals("ANALISTA"))
                .map(person -> person.getProfessional().getSalary())
                .max((x1,x2)  -> x1.compareTo(x2))
                .stream().forEach(val -> System.out.println("Maior Salario de Analista: " + val));



        //Buscar os 5 maiores salarios da profissao DESENVOLVEDOR
        //OBS: equals sendo o objeto ou nao escrita dele deve ser igual
        System.out.println("5 maiores salarios de Analista");
        people.stream()
                .filter(person -> person.getProfessional().getName().equals("ANALISTA"))
                .map(person -> person.getProfessional().getSalary())
                .sorted(Comparator.reverseOrder() )
                .limit(5).forEach(System.out::println);

        //trazeer 3 primeiros profissionais que tenham o nome que comeca com a letra "a" e "r".

       // people.stream()
        //        .filter(person -> person.getProfessional().getName().equals("A" "R"))
        //        .




     //   people.stream()
       //         .filter(person -> person.getProfessional().getName().equals("Analista"))
         //       .map(person -> person.getProfessional().getSalary())
         //       .limit(5)
          //      .max(BigDecimal::compareTo)
           //     .stream().forEach(val -> System.out.println("5 maiores salarios de Analista: " + val));



               //.forEach(val -> System.out.println("5 Maiores salarios Analista: " + val ));






    }
        private static List<Person> getPeople(){
            return
                    List.of(
                            new Person("Faizah Ballard", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
                            new Person("Alisha Harmon", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(2500.00))),
                            new Person("Rumaysa Schwartz", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1500.00))),
                            new Person("Kobi Love", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1800.00))),
                            new Person("Ralph Stokes", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(6500.00))),
                            new Person("Emmanuel Hammond", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
                            new Person("Anthony Bird", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
                            new Person("Jerome Frye", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(7500.00))),
                            new Person("Sama Keith", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
                            new Person("Alanna Sharp", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
                            new Person("Husna Suarez", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
                            new Person("Alisha Pope", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(83500.00))),
                            new Person("Toni Rawlings", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(32500.00))),
                            new Person("Piotr Harwood", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(13500.00))),
                            new Person("Roy Dean", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(23500.00))),
                            new Person("Chelsea Molina", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
                            new Person("Michelle Schneider", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(2500.00))),
                            new Person("Joshua Graham", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1500.00))),
                            new Person("Orlando Dennis", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1800.00))),
                            new Person("Emily-Rose Castro", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(6500.00))),
                            new Person("Joshua Graham", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
                            new Person("Beulah Laing", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
                            new Person("Joy Perkins", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(7500.00))),
                            new Person("Kevin Herring", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
                            new Person("Anaya Portillo", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
                            new Person("Dalia Bowler", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
                            new Person("Joy Perkins", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(983500.00))),
                            new Person("Nikodem Peralta", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(32500.00))),
                            new Person("Vikram Sharpe", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(13500.00))),
                            new Person("Kenya Hyde", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(23500.00))),
                            new Person("Mahnoor Eaton", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
                            new Person("Kennedy Craft", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(6500.00))),
                            new Person("Dewi Hayward", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(4500.00))),
                            new Person("Ruben Gomez", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(1500.00))),
                            new Person("Winifred Patel", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(2500.00))),
                            new Person("Kevin Herring", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3800.00))),
                            new Person("Mariah Odom", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3590.00))),
                            new Person("Khadija Hopkins", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(8500.00))),
                            new Person("Dennis Blaese", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(983580.00))),
                            new Person("Chloe Collins", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(32530.00))),
                            new Person("Kaia Bouvet", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(13500.00))),
                            new Person("Maisie Oneill", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(23500.00))),
                            new Person("Lilliana Davison", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3510.00))),
                            new Person("Bryn Ellwood", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(6500.00))),
                            new Person("Benjamin Prentice", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(4502.00))),
                            new Person("Malia Povey", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(2501.00))),
                            new Person("Lidia Walters", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(3510.00))),
                            new Person("Kaison Brooks", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(510.00))),
                            new Person("Billy Gomez", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(6510.00))),
                            new Person("Iolo Horne", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(9510.00))),
                            new Person("Boris Mcgrath", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(283100.00))),
                            new Person("Ebonie Bowden", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(12510.00))),
                            new Person("Will Hamilton", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(3510.00))),
                            new Person("Arielle Yu", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(25520.00))),
                            new Person("Roosevelt Fraser", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(4520.00)))
                    );

        }

}

