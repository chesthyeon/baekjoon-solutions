import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 기준 컬럼 인덱스 설정
        Map<String, Integer> columnIndex = new HashMap<>();
        columnIndex.put("code", 0);
        columnIndex.put("date", 1);
        columnIndex.put("maximum", 2);
        columnIndex.put("remain", 3);

        // 데이터 필터링
        List<int[]> filteredData = new ArrayList<>();
        for (int[] row : data) {
            if (row[columnIndex.get(ext)] < val_ext) {
                filteredData.add(row);
            }
        }

        // 데이터 정렬
        int sortIndex = columnIndex.get(sort_by);
        Collections.sort(filteredData, (a, b) -> a[sortIndex] - b[sortIndex]);

        // 결과를 2차원 배열로 변환
        return filteredData.toArray(new int[filteredData.size()][]);
    }
}