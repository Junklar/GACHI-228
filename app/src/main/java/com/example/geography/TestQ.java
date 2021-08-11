package com.example.geography;

public class TestQ {
    public static String[][] q = {
            {"З чого складається водна оболонка Землі - гідросфера?",
                    "з вод суші і Світового океану",
                    "з вод суші, Світового океану і води в атмосфері - правильно",
                    "з річок, озер, морів, боліт, ставків",
                    "тільки з вод суші"},
            {"Як називаються ділянки суші, оточені з трьох сторін водою, а з четвертого - з'єднані з нею?",
                    "материки","архіпелаги","півострова - правильно","острова"},
            {"Яка частина гідросфери не відображена на картах?",
                    "річки","моря","озера","підземні води - правильно"},
            {"Як називається безперервний процес переміщення води зі Світового океану на сушу і назад?",
                    "Світовий океан","течії","водна спільнота","Світової кругообіг води - правильно"},
            {"Яке харчування має більшість річок Росії?",
                    "снігове - правильно","дощове","льодовикове","змішане"},
            {"Який океан вважається найбільшим?",
                    "Індійський","Тихий - правильно","Атлантичний","Північний Льодовитий"},
            {"Яке озеро наполовину складається з прісної води, а наполовину - з солоної?",
                    "Байкал","Балхаш - правильно","Каспійське","Ладозьке"},
            {"Вкажіть штучну водойму:",
                    "озеро","річка","стариця","водосховище - правильно"},
            {"В яке море впадає річка Волга?:",
                    "Охотське","Чорне","Каспійське - правильно","Середземне"},
            {"Яка течія починається біля берегів Північної Америки і має північно-східний напрямок?:",
                    "Гольфстрім - правильно","Західних вітрів","Лабрадорський","Норвезький"}
    };
    public static String[][] q2 = {
            {"Як називаються ділянки суші, оточені з трьох сторін водою, а з четвертого - з'єднані з нею?",
                    "материки","архіпелаги","півострова - правильно","острова"},
    };


    public static int[] qAns = {
            2,3,4,4,1,2,2,4,3,1
    };
    public static int[] qAns2 = {
            3
    };
    public static boolean[][] ans = new boolean[q.length][q[0].length-1];
    public static boolean[][] ans2 = new boolean[q2.length][q2[0].length-1];
}
