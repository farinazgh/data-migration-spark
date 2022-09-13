import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateEpisodeWithDuplicateIds {
    public static void main(String[] args) {
        List<Episode> episodes= getEpisodes();
        System.out.println(episodes);
        convertToParquet(episodes);
    }


    static List<Episode> getEpisodes() {

        List<String> episodesStr = Arrays.asList("  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 58102752,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:48 - La Méthode scientifique - par : Nicolas Martin - Que peut le droit pour le climat ? Qu’est ce que la justice climatique ? Peut-on viser les individus ? Les entreprises ? Les Etats ? Comment défendre les générations futures et l’environnement en droit ? Quelles sanctions sont aujourd’hui envisageables pour des atteintes à l’environnement ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3528,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Justice\",\n" +
                "      \"climatique\",\n" +
                "      \":\",\n" +
                "      \"la\",\n" +
                "      \"nature\",\n" +
                "      \"peut-elle\",\n" +
                "      \"reprendre\",\n" +
                "      \"ses\",\n" +
                "      \"droits\",\n" +
                "      \"?\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/justice-climatique-la-nature-peut-elle-reprendre-ses-droits\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1491896637897842688/14312-16.10.2018-ITEMA_21853366-3.mp3\",\n" +
                "    \"name\": \"Justice climatique : la nature peut-elle reprendre ses droits ?\",\n" +
                "    \"publishingDate\": \"2018-10-16T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-16.10.2018-ITEMA_21853366-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Justice climatique : la nature peut-elle reprendre ses droits ?\",\n" +
                "    \"summary\": \"durée : 00:58:48 - La Méthode scientifique - par : Nicolas Martin - Que peut le droit pour le climat ? Qu’est ce que la justice climatique ? Peut-on viser les individus ? Les entreprises ? Les Etats ? Comment défendre les générations futures et l’environnement en droit ? Quelles sanctions sont aujourd’hui envisageables pour des atteintes à l’environnement ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"justice-climatique-la-nature-peut-elle-reprendre-s\",\n" +
                "    \"created\": \"2018-10-16T16:10:48.069Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:42.141Z\",\n" +
                "    \"id\": \"4007c7a9-8b43-4d42-aad5-d42f36e01d9c\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 57644000,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:20 - La Méthode scientifique - par : Nicolas Martin - Comment la consommation énergétique du numérique a-t-elle évolué ces dix dernières années ? En quoi le numérique est-il “énergivore” ? D’où vient l’électricité d’Internet ? Qu’appelle-t-on “sobriété numérique” ? Comment l’appliquer concrètement ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3500,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Consommation\",\n" +
                "      \"numérique\",\n" +
                "      \":\",\n" +
                "      \"la\",\n" +
                "      \"fabrique\",\n" +
                "      \"à\",\n" +
                "      \"CO2(.0)\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/consommation-numerique-la-pompe-a-co20\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1492251059903537152/14312-17.10.2018-ITEMA_21854896-3.mp3\",\n" +
                "    \"name\": \"Consommation numérique : la fabrique à CO2(.0)\",\n" +
                "    \"publishingDate\": \"2018-10-17T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-17.10.2018-ITEMA_21854896-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Consommation numérique : la fabrique à CO2(.0)\",\n" +
                "    \"summary\": \"durée : 00:58:20 - La Méthode scientifique - par : Nicolas Martin - Comment la consommation énergétique du numérique a-t-elle évolué ces dix dernières années ? En quoi le numérique est-il “énergivore” ? D’où vient l’électricité d’Internet ? Qu’appelle-t-on “sobriété numérique” ? Comment l’appliquer concrètement ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"consommation-numerique-la-fabrique-a-co20\",\n" +
                "    \"created\": \"2018-10-17T16:06:45.019Z\",\n" +
                "    \"modified\": \"2019-08-08T14:33:15.187Z\",\n" +
                "    \"id\": \"caa2617f-9488-4229-a7ec-d83b71a93da1\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 3593184,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:03:21 - La Recherche montre en main - Par Léa Bayati, doctorante au Laboratoire d’Algorithmique de Complexité et de Logique de l'Université Paris-Est Créteil\",\n" +
                "    \"duration\": 201,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Optimisation\",\n" +
                "      \"énergétique\",\n" +
                "      \"dans\",\n" +
                "      \"les\",\n" +
                "      \"centres\",\n" +
                "      \"de\",\n" +
                "      \"données\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-recherche-montre-en-main/la-recherche-montre-en-main-du-mercredi-17-octobre-2018\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1492251021961863168/14312-17.10.2018-ITEMA_21854896-2.mp3\",\n" +
                "    \"name\": \"Optimisation énergétique dans les centres de données\",\n" +
                "    \"publishingDate\": \"2018-10-17T14:54:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-17.10.2018-ITEMA_21854896-2.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Optimisation énergétique dans les centres de données\",\n" +
                "    \"summary\": \"durée : 00:03:21 - La Recherche montre en main - Par Léa Bayati, doctorante au Laboratoire d’Algorithmique de Complexité et de Logique de l'Université Paris-Est Créteil\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"optimisation-energetique-dans-les-centres-de-donne\",\n" +
                "    \"created\": \"2018-10-17T16:06:45.019Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:41.954Z\",\n" +
                "    \"id\": \"4007c7a9-8b43-4d42-aad5-d42f36e01d9c\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 58332128,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:59:02 - La Méthode scientifique - par : Nicolas Martin - La psychiatrie en France est en crise. Quelles en sont les raisons ? Pourquoi parle-t-on d’état d’urgence : accroissement du nombre de malades ou dégradation du système de soin ou les deux ? Quelles sont les failles de notre système de soins ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3542,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Psychiatrie\",\n" +
                "      \"en\",\n" +
                "      \"France\",\n" +
                "      \":\",\n" +
                "      \"ça\",\n" +
                "      \"tourne\",\n" +
                "      \"pas\",\n" +
                "      \"rond\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/psychiatrie-en-france-ca-tourne-pas-rond\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1492626034988687360/14312-18.10.2018-ITEMA_21856517-3.mp3\",\n" +
                "    \"name\": \"Psychiatrie en France : ça tourne pas rond\",\n" +
                "    \"publishingDate\": \"2018-10-18T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-18.10.2018-ITEMA_21856517-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Psychiatrie en France : ça tourne pas rond\",\n" +
                "    \"summary\": \"durée : 00:59:02 - La Méthode scientifique - par : Nicolas Martin - La psychiatrie en France est en crise. Quelles en sont les raisons ? Pourquoi parle-t-on d’état d’urgence : accroissement du nombre de malades ou dégradation du système de soin ou les deux ? Quelles sont les failles de notre système de soins ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"psychiatrie-en-france-ca-tourne-pas-rond\",\n" +
                "    \"created\": \"2018-10-18T16:17:11.973Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:41.397Z\",\n" +
                "    \"id\": \"50a3ad1f-4e65-48b6-9b2b-af883fa3040f\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 10327008,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:10:12 - Le Journal des sciences - L’échec du décollage de la fusée Soyouz et l'avenir incertain de l'ISS, le lancement de Bepicolombo, l’expérience de la parthénogenèse sur des souris, le télescope Hubble, Claire Giry présidente par intérim de l’INSERM.\",\n" +
                "    \"duration\": 612,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"L’échec\",\n" +
                "      \"du\",\n" +
                "      \"décollage\",\n" +
                "      \"de\",\n" +
                "      \"la\",\n" +
                "      \"fusée\",\n" +
                "      \"Soyouz\",\n" +
                "      \"et\",\n" +
                "      \"l'avenir\",\n" +
                "      \"incertain\",\n" +
                "      \"de\",\n" +
                "      \"l'ISS\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/le-journal-des-sciences/le-journal-des-sciences-du-vendredi-19-octobre-2018\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1493065065073483776/14312-19.10.2018-ITEMA_21858052-0.mp3\",\n" +
                "    \"name\": \"L’échec du décollage de la fusée Soyouz et l'avenir incertain de l'ISS\",\n" +
                "    \"publishingDate\": \"2018-10-19T14:05:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-19.10.2018-ITEMA_21858052-0.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"L’échec du décollage de la fusée Soyouz et l'avenir incertain de l'ISS\",\n" +
                "    \"summary\": \"durée : 00:10:12 - Le Journal des sciences - L’échec du décollage de la fusée Soyouz et l'avenir incertain de l'ISS, le lancement de Bepicolombo, l’expérience de la parthénogenèse sur des souris, le télescope Hubble, Claire Giry présidente par intérim de l’INSERM.\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"le-journal-des-sciences-19102018\",\n" +
                "    \"created\": \"2018-10-19T14:40:45.711Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:41.146Z\",\n" +
                "    \"id\": \"4007c7a9-8b43-4d42-aad5-d42f36e01d9c\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 58151904,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:51 - La Méthode scientifique - par : Nicolas Martin - Publiée sous la direction de Roland Lehoucq, la collection Parallaxe des éditions du Bélial' se propose de faire dialoguer science et SF sous la plume de scientifiques. Plongée dans l’univers de la linguistique fiction, sujet de l'un des deux premiers volumes de cette nouvelle collection. - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3531,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Collection\",\n" +
                "      \"Parallaxe\",\n" +
                "      \":\",\n" +
                "      \"le\",\n" +
                "      \"laboratoire\",\n" +
                "      \"de\",\n" +
                "      \"la\",\n" +
                "      \"science-fiction\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/la-methode-scientifique-du-vendredi-19-octobre-2018\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1493065073264959488/14312-19.10.2018-ITEMA_21858052-3.mp3\",\n" +
                "    \"name\": \"Collection Parallaxe : le laboratoire de la science-fiction\",\n" +
                "    \"publishingDate\": \"2018-10-19T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-19.10.2018-ITEMA_21858052-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Collection Parallaxe : le laboratoire de la science-fiction\",\n" +
                "    \"summary\": \"durée : 00:58:51 - La Méthode scientifique - par : Nicolas Martin - Publiée sous la direction de Roland Lehoucq, la collection Parallaxe des éditions du Bélial' se propose de faire dialoguer science et SF sous la plume de scientifiques. Plongée dans l’univers de la linguistique fiction, sujet de l'un des deux premiers volumes de cette nouvelle collection. - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"collection-parallaxe-le-laboratoire-de-la-science-\",\n" +
                "    \"created\": \"2018-10-19T16:07:16.127Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:40.954Z\",\n" +
                "    \"id\": \"13f1ba7a-4a13-4954-a512-b73ba3be18b2\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 57873376,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:34 - La Méthode scientifique - par : Nicolas Martin - D’où viennent les hommes de Denisova ? Qu’a permis la génétique dans la compréhension de Denisova ? La paléogénétique : qu’est-ce que c’est ? Dans quels domaines permet-elle d’apporter des éléments ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3514,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Denisova\",\n" +
                "      \"à\",\n" +
                "      \"un\",\n" +
                "      \"doigt\",\n" +
                "      \"de\",\n" +
                "      \"Neandertal\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/la-methode-scientifique-du-lundi-22-octobre-2018\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1494105195498446848/14312-22.10.2018-ITEMA_21861752-3.mp3\",\n" +
                "    \"name\": \"Denisova, à un doigt de Neandertal\",\n" +
                "    \"publishingDate\": \"2018-10-22T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-22.10.2018-ITEMA_21861752-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Denisova, à un doigt de Neandertal\",\n" +
                "    \"summary\": \"durée : 00:58:34 - La Méthode scientifique - par : Nicolas Martin - D’où viennent les hommes de Denisova ? Qu’a permis la génétique dans la compréhension de Denisova ? La paléogénétique : qu’est-ce que c’est ? Dans quels domaines permet-elle d’apporter des éléments ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"denisova-a-un-doigt-de-neandertal\",\n" +
                "    \"created\": \"2018-10-22T15:38:35.652Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:40.814Z\",\n" +
                "    \"id\": \"59a86581-296c-4518-97bf-4607efc4a6ef\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 57938912,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:38 - La Méthode scientifique - par : Nicolas Martin - L’Inde et la Chine : des pionniers asiatiques de la recherche spatiale ? Entre compétition et coopération, les programmes spatiaux indiens et chinois vont-ils relancer la conquête spatiale ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3518,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"L’espace\",\n" +
                "      \"made\",\n" +
                "      \"in\",\n" +
                "      \"Asia\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/lespace-made-asia\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1494475888014663680/14312-23.10.2018-ITEMA_21863308-3.mp3\",\n" +
                "    \"name\": \"L’espace made in Asia\",\n" +
                "    \"publishingDate\": \"2018-10-23T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-23.10.2018-ITEMA_21863308-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"L’espace made in Asia\",\n" +
                "    \"summary\": \"durée : 00:58:38 - La Méthode scientifique - par : Nicolas Martin - L’Inde et la Chine : des pionniers asiatiques de la recherche spatiale ? Entre compétition et coopération, les programmes spatiaux indiens et chinois vont-ils relancer la conquête spatiale ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"lespace-made-in-asia\",\n" +
                "    \"created\": \"2018-10-23T15:47:15.991Z\",\n" +
                "    \"modified\": \"2019-08-08T14:33:15.108Z\",\n" +
                "    \"id\": \"13f1ba7a-4a13-4954-a512-b73ba3be18b2\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 57971680,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:58:40 - La Méthode scientifique - par : Nicolas Martin - Quelles sont les difficultés rencontrées pour lire et interpréter une activité cérébrale ? Qu’appelle-t-on lire dans les pensées ? Quel est le langage de la pensée ? Que peut-on attendre des ICM dans le futur ? Peut-on penser à la télépathie via la machine ? - réalisé par : Olivier Bétard\",\n" +
                "    \"duration\": 3520,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Mind\",\n" +
                "      \"Reading\",\n" +
                "      \"l’ordinateur\",\n" +
                "      \"télépathe\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-methode-scientifique/mind-reading-lordinateur-telepathe\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1494852183332495360/14312-24.10.2018-ITEMA_21864850-3.mp3\",\n" +
                "    \"name\": \"Mind Reading, l’ordinateur télépathe\",\n" +
                "    \"publishingDate\": \"2018-10-24T14:55:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-24.10.2018-ITEMA_21864850-3.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Mind Reading, l’ordinateur télépathe\",\n" +
                "    \"summary\": \"durée : 00:58:40 - La Méthode scientifique - par : Nicolas Martin - Quelles sont les difficultés rencontrées pour lire et interpréter une activité cérébrale ? Qu’appelle-t-on lire dans les pensées ? Quel est le langage de la pensée ? Que peut-on attendre des ICM dans le futur ? Peut-on penser à la télépathie via la machine ? - réalisé par : Olivier Bétard\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"mind-reading-lordinateur-telepathe\",\n" +
                "    \"created\": \"2018-10-24T16:22:31.313Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:40.271Z\",\n" +
                "    \"id\": \"61d764f5-459b-4343-9f2b-55d62be080dc\",\n" +
                "    \"deleted\": false\n" +
                "  }\n", "  {\n" +
                "    \"author\": \"podcast@radiofrance.com\",\n" +
                "    \"categories\": [\n" +
                "      \"Science & Medicine\"\n" +
                "    ],\n" +
                "    \"contentLength\": 5510112,\n" +
                "    \"contentType\": \"audio/mpeg\",\n" +
                "    \"description\": \"durée : 00:05:18 - La Recherche montre en main - Par Jean-Maurice Leonetti, doctorant au sein de l'ENS dans le Laboratoire de Sciences Cognitives et Psycholinguistiques du Département d’études Cognitive.\",\n" +
                "    \"duration\": 318,\n" +
                "    \"episodeNumber\": null,\n" +
                "    \"episodeType\": \"full\",\n" +
                "    \"hosted\": false,\n" +
                "    \"image\": null,\n" +
                "    \"keywords\": [\n" +
                "      \"Étude\",\n" +
                "      \"de\",\n" +
                "      \"la\",\n" +
                "      \"conscience\",\n" +
                "      \"par\",\n" +
                "      \"interfaces\",\n" +
                "      \"cerveau-machine\"\n" +
                "    ],\n" +
                "    \"link\": \"https://www.franceculture.fr/emissions/la-recherche-montre-en-main/la-recherche-montre-en-main-du-mercredi-24-octobre-2018\",\n" +
                "    \"mediaUrl\": \"http://rf.proxycast.org/1494852156019187712/14312-24.10.2018-ITEMA_21864850-2.mp3\",\n" +
                "    \"name\": \"Étude de la conscience par interfaces cerveau-machine\",\n" +
                "    \"publishingDate\": \"2018-10-24T14:54:00Z\",\n" +
                "    \"rssGuid\": \"http://media.radiofrance-podcast.net/podcast09/14312-24.10.2018-ITEMA_21864850-2.mp3\",\n" +
                "    \"seasonNumber\": null,\n" +
                "    \"showId\": \"72385288-57d5-4975-953c-a32c67cfd39e\",\n" +
                "    \"subtitle\": \"Étude de la conscience par interfaces cerveau-machine\",\n" +
                "    \"summary\": \"durée : 00:05:18 - La Recherche montre en main - Par Jean-Maurice Leonetti, doctorant au sein de l'ENS dans le Laboratoire de Sciences Cognitives et Psycholinguistiques du Département d’études Cognitive.\",\n" +
                "    \"rating\": \"no\",\n" +
                "    \"adSettings\": {},\n" +
                "    \"timeline\": [],\n" +
                "    \"url\": \"etude-de-la-conscience-par-interfaces-cerveau-mach\",\n" +
                "    \"created\": \"2018-10-24T16:22:31.313Z\",\n" +
                "    \"modified\": \"2018-11-15T16:56:40.510Z\",\n" +
                "    \"id\": \"13f1ba7a-4a13-4954-a512-b73ba3be18b2\",\n" +
                "    \"deleted\": false\n" +
                "  }\n");


        List<Episode> episodes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            for (String json : episodesStr) {
                Episode episode = null;
                episode = objectMapper.readValue(json, Episode.class);
                episodes.add(episode);

            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return episodes;
    }


  /* void uploadToS3() {
        File parquetFile = null;
        try {
            parquetFile = convertToParquet(getEpisodes());
            if (parquetFile != null && parquetFile.getPath() != null) {
                final InputStream parquetStream = new DataInputStream(
                        new FileInputStream(parquetFile.getAbsoluteFile()));
                String fileName = System.currentTimeMillis() +"";
                // to store the converted data to AWS S3
                // this.awsClientImpl.uploadToS3(chronoMap, fileName, parquetStream);
            }
        } catch (Exception e) {
            System.out.println("exception {}"+ e);
            e.printStackTrace();
        }
    }*/

    private static void convertToParquet(List<Episode> list) {
        JavaSparkContext sparkContext = null;
        try (SparkSession spark = SparkSession.builder()
                .master("local[4]")
                .appName("ConvertorApp")
                .getOrCreate()) {
            Gson gson = new Gson();
            List<String> data = Collections.singletonList(gson.toJson(list));
            sparkContext = JavaSparkContext.fromSparkContext(SparkContext.getOrCreate());
            Dataset<String> stringDataSet = spark.createDataset(data, Encoders.STRING());
            Dataset<Row> parquetDataSet = spark.read().json(stringDataSet);
            System.out.println("Inserted json conversion schema and value");
            parquetDataSet.printSchema();
            parquetDataSet.show();
            parquetDataSet.write().parquet("parquetFromjson"+System.currentTimeMillis()+".parquet");
//                tempFile = this.retrieveParquetFileFromPath(tempFile);
        } catch (Exception ex) {
            System.out.println("Stack Trace: {}" + ex);
        } finally {
            if (sparkContext != null) {
                sparkContext.close();
            }
        }
    }


/*
    private File retrieveParquetFileFromPath(File tempFilePath) {
        List<File> files = Arrays.asList(tempFilePath.listFiles());
        return files.stream()
                .filter(
                        tmpFile -> tmpFile.getPath().contains(FILE_EXTENSION) && tmpFile.getPath().endsWith(FILE_EXTENSION))
                .findAny()
                .orElse(null);
    }*/
}
