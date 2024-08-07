with newT as (
    select fish_type, (
        case 
    when length is null then 10
    else length end) as length, time
    from fish_info
)
select count(fish_type) as fish_count, max(length) as max_length, fish_type
from newT
group by fish_type
having avg(length) >= 33
order by fish_type