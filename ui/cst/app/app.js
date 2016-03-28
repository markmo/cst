import './theme';
import './store';
import './actions';
import { router, route } from 'reapp-kit';

router(require,
  route('home', 'customers/:customerId',
    route('sub', 'events/:time')
  )
  //route('home', '/')
);