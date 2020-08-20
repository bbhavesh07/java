-- There is a table Employee with emp_id, name, salary, dept_id. Find top 3 emp_names with highest paid salary per dept.
-- there is an analytical function row_number() which tags row_num for each selected row.
-- in row_number() partition is used instead of group by.
select departments.name from
    (select row_number() over(partition by e.dept_id order by e.salary DESC)
     as row_num, e.* from employee as e) as departments
where departments.row_num in (1,2,3);
-- instead in (1,2,3): departments.row_num < 4


-- below is the order of execution for different sql clause
  FROM & JOIN  determine & filter rows
  WHERE more filters on the rows
  GROUP BY combines those rows into groups
  HAVING filters groups
  ORDER BY arranges the remaining rows/groups
  LIMIT filters on the remaining rows/groups

-- Here please note that LIMIT and rownum are executed at last. though you write rownum < n in where clause.