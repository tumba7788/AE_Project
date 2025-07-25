package api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteItemRequest {
    private List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String itemIds;
    }
}
