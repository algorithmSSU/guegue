import java.util.*;

class BestAlbum {
    List<Integer> answer;
    Map<String, Integer> playSumAboutGenresMap;

    private void init(){
        answer = new ArrayList<Integer>();

        playSumAboutGenresMap = new HashMap<>();
    }

    public int[] solution(String[] genres, int[] plays) {
        init();
        setPlaysSumAboutGenresMap(genres, plays);

        List<Map.Entry<String, Integer>> playSumEntryList = sortMapByValueDesc(playSumAboutGenresMap);


        for(Map.Entry<String, Integer> mapEntry : playSumEntryList){
            Map<Integer, Integer> genreSongCountByIdMap = getGenreSongCountByIdMap(mapEntry.getKey(), genres, plays);
            List<Map.Entry<Integer, Integer>> songIdPlayCountMapList = sortMapByValueDesc(genreSongCountByIdMap, 0);
            int size = (songIdPlayCountMapList.size() >= 2) ? 2 : songIdPlayCountMapList.size();
            for(int i = 0 ; i < size; i++){
                answer.add(songIdPlayCountMapList.get(i).getKey());
            }
        }

        int[] answerArray = getAnswerArray();
        return answerArray;
    }

    private void setPlaysSumAboutGenresMap(String[] genres, int[] plays){
        int size = genres.length;
        for(int i = 0 ; i < size; i++){
            playSumAboutGenresMap.put(genres[i], playSumAboutGenresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
    }

    private Map<Integer, Integer> getGenreSongCountByIdMap(String targetGenre, String[] genres, int[] plays){

        Map<Integer, Integer> genreSongCountByIdMap = new HashMap<>();

        int size = genres.length;
        for(int i = 0; i < size; i++){
            if(targetGenre.equals(genres[i])){
                genreSongCountByIdMap.put(i, plays[i]);
            }
        }

        return genreSongCountByIdMap;
    }

    private List<Map.Entry<String, Integer>> sortMapByValueDesc(Map<String, Integer> map){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });

        return list;
    }

    private List<Map.Entry<Integer, Integer>> sortMapByValueDesc(Map<Integer, Integer> map, int n){
        n = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });

        return list;
    }

    private int[] getAnswerArray(){
        int[] answerArray = new int[answer.size()];
        for(int i = 0 ; i < answer.size(); i++){
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }
}
