package com.erp.core.dto.response.Material;

/**
 * DTO phía response biểu diễn một nguyên vật liệu (master data), dùng để FE
 * hiển thị dropdown chọn nguyên vật liệu (vd. trong màn Bảng giá NCC).
 *
 * <p>Chỉ chứa các trường thực tế của entity {@code Material}; không join thêm
 * tên category/unit để giữ nhẹ, FE chỉ cần {@code code} + {@code name}.</p>
 */
public record MaterialResponse(

        /** ID nguyên vật liệu (UUID dạng chuỗi). */
        String id,

        /** Mã nguyên vật liệu. */
        String code,

        /** Tên nguyên vật liệu. */
        String name,

        /** ID nhóm nguyên vật liệu (UUID dạng chuỗi, nullable). */
        String categoryId,

        /** ID đơn vị tính cơ bản (UUID dạng chuỗi, nullable). */
        String baseUnitId,

        /** Trạng thái bản ghi (ACTIVE/INACTIVE). */
        String status
) {
}
