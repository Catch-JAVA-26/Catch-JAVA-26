class Solution {
    static final int PILLAR = 0, BARRAGE = 1, REMOVE = 0, ADD = 1;
    int n;
    boolean[][] pillars;
    boolean[][] barrages;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        this.n = n;
        pillars = new boolean[n+1][n+1];
        barrages = new boolean[n+1][n+1];
        int len = 0;

        for (int[] build: build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];

            if (cmd == ADD) {
                if (type == PILLAR && isOkPillar(x, y)) { // 기둥 추가
                    pillars[y][x] = true;
                    len++;
                } else if (type == BARRAGE && isOkBarrage(x, y)) { // 보 추가
                    barrages[y][x] = true;
                    len++;
                }
            } else {
                if (type == PILLAR && isRemovable(x, y, type)) { // 기둥 삭제
                    pillars[y][x] = false;
                    len--;
                } else if (type == BARRAGE && isRemovable(x, y, type)) { // 보 삭제
                    barrages[y][x] = false;
                    len--;
                }
            }
        }

        answer = new int[len][3];
        int index = 0;
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (pillars[j][i]) {
                    answer[index++] = new int[]{i, j, PILLAR};
                }
                if (barrages[j][i]) {
                    answer[index++] = new int[]{i, j, BARRAGE};
                }
            }
        }

        return answer;
    }

    public boolean isOkPillar(int x, int y) {
        if (y == 0) {
            return true;
        } else if (pillars[y-1][x]) {
            return true;
        } else if (x-1 >= 0 && barrages[y][x-1] || barrages[y][x]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOkBarrage(int x, int y) {
        if (y-1 >= 0 && pillars[y-1][x] || pillars[y-1][x+1]) {
            return true;
        } else if (x-1 >= 0 && barrages[y][x-1] && barrages[y][x+1]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRemovable(int x, int y, int type) {
        boolean result = true;

        if (type == PILLAR) {
            pillars[y][x] = false;
        } else {
            barrages[y][x] = false;
        }

        loop:
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (pillars[i][j] && !isOkPillar(j, i)) {
                    result = false;
                    break loop;
                }
                if (barrages[i][j] && !isOkBarrage(j, i)) {
                    result = false;
                    break loop;
                }
            }
        }

        if (type == PILLAR) {
            pillars[y][x] = true;
        } else {
            barrages[y][x] = true;
        }

        return result;
    }
}