import { React, List } from 'reapp-kit';
import moment from 'moment';

class EventListItem extends React.Component {

  render() {
    const event = this.props.item;
    const index = this.props.index;
    return (
      <List.Item
        key={index}
        title={moment(event.time).format('D/M/YYYY')}
        titleSub={event.type + '-' + event.subtype}
        index={index}
        onTap={() => this.context.router.transitionTo('sub', {customerId: '2004226978', time: event.time})}
        icon>
      </List.Item>
    );
  }
}

export default EventListItem;
