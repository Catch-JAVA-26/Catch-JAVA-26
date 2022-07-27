import java.util.*;

class Seunghyeon {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> genre_plays = new HashMap<>();
        Map<String, Map<Integer, Integer>> genre_song_plays = new HashMap<>();
        Map<String, List<Integer>> bestAlbum = new HashMap<>();
        int size = 0;

        for (int i=0; i<genres.length; i++) {
            genre_plays.put(genres[i], genre_plays.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> hm = genre_song_plays.getOrDefault(genres[i], new HashMap<>());
            hm.put(i, plays[i]);
            genre_song_plays.put(genres[i], hm);
        }

        List<Map.Entry<String, Integer>> list_genre_plays = new ArrayList<>(genre_plays.entrySet());
        Collections.sort(list_genre_plays, (o1, o2) -> o2.getValue() - o1.getValue());


        for (Map.Entry<String, Map<Integer, Integer>> entry: genre_song_plays.entrySet()) {
            Map<Integer, Integer> map = entry.getValue();
            List<Map.Entry<Integer, Integer>> list_genre_song_plays = new ArrayList<>(map.entrySet());
            Collections.sort(list_genre_song_plays, (o1, o2) -> o2.getValue() - o1.getValue());
            List<Integer> album = new ArrayList<>();
            album.add(list_genre_song_plays.get(0).getKey());
            size++;
            if (list_genre_song_plays.size() > 1) {
                album.add(list_genre_song_plays.get(1).getKey());
                size++;
            }
            bestAlbum.put(entry.getKey(), album);
        }

        answer = new int[size];

        int i=0;
        for (Map.Entry<String, Integer> entry: list_genre_plays) {
            List<Integer> album = bestAlbum.get(entry.getKey());
            answer[i++] = album.get(0);
            if (album.size() > 1) {
                answer[i++] = album.get(1);
            }
        }

        return answer;
    }
}