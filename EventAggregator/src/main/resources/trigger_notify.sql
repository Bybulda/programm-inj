CREATE OR REPLACE FUNCTION notify_user_change()
    RETURNS trigger AS $$
DECLARE
    payload TEXT;
BEGIN
    payload := json_build_object(
            'operation', TG_OP,
            'table', TG_TABLE_NAME,
            'timestamp', now(),
            'data', row_to_json(NEW)
               )::TEXT;

    PERFORM pg_notify('data_changes', payload);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trigger_user_change ON users;

CREATE TRIGGER trigger_user_change
    AFTER INSERT OR UPDATE ON users
    FOR EACH ROW
EXECUTE FUNCTION notify_user_change();
