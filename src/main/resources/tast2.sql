SELECT
f.name faculties,
COUNT(s.id) count_students
FROM faculties f
LEFT JOIN students s ON f.id = s.fac_id
GROUP BY f.name