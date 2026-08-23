package com.erp.core.constants;

/**
 * Physical table names for the 8 auth reference tables.
 */
public final class TableName {

    public static final String ACCOUNT = "account";
    public static final String ROLE = "role";
    public static final String PERMISSION = "permission";
    public static final String ROLE_PERMISSION = "role_permission";
    public static final String SCOPE = "scope";
    public static final String ACCOUNT_ROLE_ASSIGNMENT = "account_role_assignment";
    public static final String AUDIT_LOG = "audit_log";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CUSTOMER = "customer";
    public static final String CUSTOMER_ADDRESS = "customer_address";
    public static final String BRANCH = "branch";

    // ---- BRANCH module (003-branch) ----
    public static final String BRANCH_HOURS = "branch_hours";
    public static final String PICKUP_TIME_SLOT = "pickup_time_slot";

    // ---- INV module (005-inv) ----
    public static final String UNIT = "unit";
    public static final String CATEGORY = "category";
    public static final String MATERIAL = "material";
    public static final String WAREHOUSE = "warehouse";
    public static final String MATERIAL_STOCK_BALANCE = "material_stock_balance";
    public static final String STOCK_IN = "stock_in";
    public static final String STOCK_IN_ITEM = "stock_in_item";
    public static final String STOCK_OUT = "stock_out";
    public static final String STOCK_OUT_ITEM = "stock_out_item";
    public static final String STOCK_TRANSFER = "stock_transfer";
    public static final String STOCK_TRANSFER_ITEM = "stock_transfer_item";
    public static final String STOCK_COUNT = "stock_count";
    public static final String STOCK_COUNT_ITEM = "stock_count_item";

    // ---- PROC module (006-proc) ----
    public static final String SUPPLIER = "supplier";
    public static final String SUPPLIER_MATERIAL = "supplier_material";
    public static final String PURCHASE_ORDER = "purchase_order";
    public static final String PURCHASE_ORDER_ITEM = "purchase_order_item";

    // ---- MENU module (007-menu) ----
    public static final String PRODUCT = "product";
    public static final String PRODUCT_VARIANT = "product_variant";
    public static final String PRODUCT_RECIPE_ITEM = "product_recipe_item";
    public static final String TOPPING = "topping";
    public static final String PRODUCT_TOPPING = "product_topping";
    public static final String COMBO_ITEM = "combo_item";
    public static final String BRANCH_PRODUCT_AVAILABILITY = "branch_product_availability";
    public static final String BRANCH_TOPPING_AVAILABILITY = "branch_topping_availability";
    public static final String VOUCHER = "voucher";
    public static final String VOUCHER_BRANCH = "voucher_branch";

    // ---- STORE module (008-store) ----
    public static final String SHIFT = "shift";
    public static final String SHIFT_ASSIGNMENT = "shift_assignment";
    public static final String STORE_DAILY_REPORT = "store_daily_report";
    public static final String BRANCH_VARIANT_DAILY_STOCK = "branch_variant_daily_stock";
    public static final String BRANCH_VARIANT_STOCK_LOG = "branch_variant_stock_log";

    // ---- POS module (009-pos) ----
    public static final String CART = "cart";
    public static final String CART_ITEM = "cart_item";
    public static final String CART_ITEM_TOPPING = "cart_item_topping";
    public static final String ORDERS = "orders";
    public static final String ORDER_DELIVERY = "order_delivery";
    public static final String ORDER_ITEM = "order_item";
    public static final String ORDER_ITEM_TOPPING = "order_item_topping";
    public static final String ORDER_STATUS_HISTORY = "order_status_history";
    public static final String PAYMENT_INTENT = "payment_intent";
    public static final String KDS_TICKET = "kds_ticket";
    public static final String KDS_TICKET_ITEM = "kds_ticket_item";
    public static final String REFUND = "refund";
    public static final String VOUCHER_USAGE = "voucher_usage";

    // ---- FIN module (010-fin) ----
    public static final String ACCOUNTS_PAYABLE = "accounts_payable";
    public static final String ACCOUNTS_PAYABLE_PAYMENT = "accounts_payable_payment";
    public static final String EXPENSE = "expense";
    public static final String BRANCH_DAILY_FINANCIAL_SUMMARY = "branch_daily_financial_summary";

    // ---- PLATFORM module (011-platform) ----
    public static final String NOTIFICATION_TEMPLATE = "notification_template";
    public static final String NOTIFICATION = "notification";
    public static final String IDEMPOTENCY_KEY = "idempotency_key";

    private TableName() {
    }
}
